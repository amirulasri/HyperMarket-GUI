package gui;

import classes.CustomerInformation;
import classes.ItemInformation;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ItemUI extends javax.swing.JFrame {

    private String frameItemTitle = "";
    private String itemIDPopup = "";
    private String custID;
    private int counterNumber = 0;

    /**
     * Creates new form ItemUI
     *
     * @param custID
     * @param counterNumber
     */
    public ItemUI(String custID, int counterNumber) {
        this.custID = custID;
        this.counterNumber = counterNumber;
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ItemUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        frameItemTitle = "Items for customer " + custID;
        initComponents();
        itemtitlelabel.setText("List Item for customer " + custID);
        pack();
        setLocationRelativeTo(null);
        displayItemToTable();

        //CREATE POPUP MENU AND ACTION CLICK
        ImageIcon editicon = new ImageIcon("src/images/edit.png");
        ImageIcon deleteicon = new ImageIcon("src/images/delete.png");
        ImageIcon cancelicon = new ImageIcon("src/images/cancel.png");
        JPopupMenu popupItem;
        popupItem = new JPopupMenu();
        JMenuItem editItemsMenuItem = new JMenuItem("Edit", editicon);
        JMenuItem deleteItemsMenuItem = new JMenuItem("Delete", deleteicon);
        popupItem.add("custPopupEdit", editItemsMenuItem);
        popupItem.add("custPopupDelete", deleteItemsMenuItem);
        popupItem.add(new JMenuItem("Cancel", cancelicon));

        //EDIT ITEMS HERE
        Map<String, EditItemUI> edititemInstance = new TreeMap<String, EditItemUI>();
        editItemsMenuItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                System.out.println("MENU EDIT CLICKED: ");
                EditItemUI getEditItemUI = edititemInstance.get("edititem" + custID + itemIDPopup);
                if (getEditItemUI == null) {
                    EditItemUI newItemUI = new EditItemUI(counterNumber, custID, itemIDPopup);
                    edititemInstance.put("edititem" + custID + itemIDPopup, newItemUI);
                    newItemUI.setVisible(true);
                    newItemUI.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            displayItemToTable();
                        }

                    });
                } else {
                    getEditItemUI.setVisible(true);
                }
            }
        });

        //REMOVE ITEMS HERE
        deleteItemsMenuItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                System.out.println("MENU DELETE CLICKED: ");
                Predicate<CustomerInformation> itemCondition = items -> items.getItemID().equalsIgnoreCase(itemIDPopup) && items.getCustID().equalsIgnoreCase(custID);
                if (counterNumber == 1) {
                    bahagiamall.BahagiaMall.getCounter1().removeIf(itemCondition);
                } else if (counterNumber == 2) {
                    bahagiamall.BahagiaMall.getCounter2().removeIf(itemCondition);
                } else if (counterNumber == 3) {
                    bahagiamall.BahagiaMall.getCounter3().removeIf(itemCondition);
                }
                displayItemToTable();
            }
        });

        itemTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.getButton() == MouseEvent.BUTTON3) {
                    int tablepoint = itemTable.rowAtPoint(me.getPoint());
                    if (tablepoint >= 0 && tablepoint < itemTable.getRowCount()) {
                        itemTable.setRowSelectionInterval(tablepoint, tablepoint);
                    } else {
                        itemTable.clearSelection();
                    }
                    JTable target = (JTable) me.getSource();
                    int row = target.getSelectedRow(); // select a row
                    String getCustIDFromTable = (String) itemTable.getValueAt(row, 0);
                    itemIDPopup = getCustIDFromTable;
                    popupItem.show(me.getComponent(), me.getX(), me.getY());
                }
            }
        });
    }

    ImageIcon logo = new ImageIcon("src/images/mainicon.png");

    private void displayItemToTable() {
        DefaultTableModel itemTableModel = (DefaultTableModel) itemTable.getModel();
        itemTableModel.setRowCount(0);
        //TO CONVERT, NEED TO FILTER ITEM ONLY AND ADD TO NEW LIST
        List<CustomerInformation> convertedItemList = null;
        List<CustomerInformation> filteredItemListCust = null;
        if (counterNumber == 1) {
            convertedItemList = (List<CustomerInformation>) bahagiamall.BahagiaMall.getCounter1().stream().collect(Collectors.toList());
            filteredItemListCust = convertedItemList.stream().filter(items -> items.getCustID().equalsIgnoreCase(custID)).collect(Collectors.toList());
        } else if (counterNumber == 2) {
            convertedItemList = (List<CustomerInformation>) bahagiamall.BahagiaMall.getCounter2().stream().collect(Collectors.toList());
            filteredItemListCust = convertedItemList.stream().filter(items -> items.getCustID().equalsIgnoreCase(custID)).collect(Collectors.toList());
        } else if (counterNumber == 3) {
            convertedItemList = (List<CustomerInformation>) bahagiamall.BahagiaMall.getCounter3().stream().collect(Collectors.toList());
            filteredItemListCust = convertedItemList.stream().filter(items -> items.getCustID().equalsIgnoreCase(custID)).collect(Collectors.toList());
        }

        countlabelitem.setText(filteredItemListCust.size() + " Items");

        for (Iterator iterator = filteredItemListCust.iterator(); iterator.hasNext();) {
            CustomerInformation nextItemData = (CustomerInformation) iterator.next();
            itemTableModel.addRow(new Object[]{nextItemData.getItemID(), nextItemData.getItemName(), nextItemData.getitemPrice(), nextItemData.getDatePurchase()});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        itemtitlelabel = new javax.swing.JLabel();
        countlabelitem = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(frameItemTitle);
        setIconImage(logo.getImage());

        jPanel2.setBackground(new java.awt.Color(255, 196, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        itemtitlelabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        itemtitlelabel.setText("List Item for customer -");

        countlabelitem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        countlabelitem.setText("0 Items");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemtitlelabel)
                    .addComponent(countlabelitem))
                .addContainerGap(569, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(itemtitlelabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(countlabelitem)
                .addContainerGap())
        );

        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Item Name", "Price", "Date Purchased"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(itemTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel countlabelitem;
    private javax.swing.JTable itemTable;
    private javax.swing.JLabel itemtitlelabel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
