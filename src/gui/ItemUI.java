package gui;

import classes.CustomerInformation;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ItemUI extends javax.swing.JFrame {

    private String frameItemTitle = "";
    private String custID;
    private int counterNumber = 0;
    private double totalPayment = 0;

    /**
     * Creates new form ItemUI
     *
     * @param custID
     * @param counterNumber
     */
    public ItemUI(String custID, int counterNumber, String editable) {
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
        if (editable.equals("editable")) {
            additembutton.setVisible(true);
        } else {
            additembutton.setVisible(false);
        }
        pack();
        setLocationRelativeTo(null);
        displayItemToTable();
    }

    private ImageIcon logo = new ImageIcon("src/images/mainicon.png");

    private void displayItemToTable() {
        DefaultTableModel itemTableModel = (DefaultTableModel) itemTable.getModel();
        itemTableModel.setRowCount(0);
        //TO CONVERT, NEED TO FILTER ITEM ONLY AND ADD TO NEW LIST
        List<CustomerInformation> convertedItemList = null;
        List<CustomerInformation> filteredItemListCust = null;
        if (counterNumber == 1) {
            convertedItemList = (List<CustomerInformation>) hypermarket.HyperMarket.getCounter1().stream().collect(Collectors.toList());
            filteredItemListCust = convertedItemList.stream().filter(items -> items.getCustID().equalsIgnoreCase(custID)).collect(Collectors.toList());
        } else if (counterNumber == 2) {
            convertedItemList = (List<CustomerInformation>) hypermarket.HyperMarket.getCounter2().stream().collect(Collectors.toList());
            filteredItemListCust = convertedItemList.stream().filter(items -> items.getCustID().equalsIgnoreCase(custID)).collect(Collectors.toList());
        } else if (counterNumber == 3) {
            convertedItemList = (List<CustomerInformation>) hypermarket.HyperMarket.getCounter3().stream().collect(Collectors.toList());
            filteredItemListCust = convertedItemList.stream().filter(items -> items.getCustID().equalsIgnoreCase(custID)).collect(Collectors.toList());
        }

        countlabelitem.setText(filteredItemListCust.size() + " Items");

        for (Iterator iterator = filteredItemListCust.iterator(); iterator.hasNext();) {
            CustomerInformation nextItemData = (CustomerInformation) iterator.next();
            //ALSO CALCULATE TOTAL PAYMENT HERE
            totalPayment = totalPayment + nextItemData.getItemPrice();
            itemTableModel.addRow(new Object[]{nextItemData.getItemID(), nextItemData.getItemName(), "RM " + nextItemData.getItemPrice(), nextItemData.getDatePurchase()});
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
        additembutton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(frameItemTitle);
        setIconImage(logo.getImage());

        jPanel2.setBackground(new java.awt.Color(255, 196, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        itemtitlelabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        itemtitlelabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/products.png"))); // NOI18N
        itemtitlelabel.setText("List Item for customer -");

        countlabelitem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        countlabelitem.setText("0 Items");

        additembutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus.png"))); // NOI18N
        additembutton.setText("Add item");
        additembutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                additembuttonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(itemtitlelabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(additembutton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(countlabelitem)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemtitlelabel)
                    .addComponent(additembutton))
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void additembuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_additembuttonMouseClicked
        //ADD ITEM HERE
        if (hypermarket.HyperMarket.getAddItemUI() == null) {
            hypermarket.HyperMarket.createItemAddUIInstance(counterNumber, custID);
            hypermarket.HyperMarket.getAddItemUI().setVisible(true);
            hypermarket.HyperMarket.getAddItemUI().addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    hypermarket.HyperMarket.setItemAddUINull();
                    displayItemToTable();
                }
            });
        } else {
            hypermarket.HyperMarket.getAddItemUI().setVisible(true);
            JOptionPane.showMessageDialog(null, "There are customers who have not finished managing items. Please finish first and try again", "Error Customer Queue", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_additembuttonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton additembutton;
    private javax.swing.JLabel countlabelitem;
    private javax.swing.JTable itemTable;
    private javax.swing.JLabel itemtitlelabel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
