package gui;

import classes.CustomerInformation;
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

public class CounterUI extends javax.swing.JFrame {

    private String counterNameTitle = "Counter";
    private String custIDPopupMenu = "";

    /**
     * Creates new form CounterUI
     */
    public CounterUI(int counterNumber) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CounterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CounterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CounterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CounterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        counterNameTitle = "Counter " + counterNumber;
        initComponents();
        pack();
        setLocationRelativeTo(null);
        counterlabel.setText("Counter " + counterNumber);
        if (counterNumber == 1) {
            displayCustomerToTable(bahagiamall.BahagiaMall.getCounter1());
        } else if (counterNumber == 2) {
            displayCustomerToTable(bahagiamall.BahagiaMall.getCounter2());
        } else if (counterNumber == 3) {
            displayCustomerToTable(bahagiamall.BahagiaMall.getCounter3());
        }

        //CREATE POPUP MENU AND ACTION CLICK
        ImageIcon editicon = new ImageIcon("src/images/edit.png");
        ImageIcon deleteicon = new ImageIcon("src/images/delete.png");
        ImageIcon cancelicon = new ImageIcon("src/images/cancel.png");
        JPopupMenu popupCustomer;
        popupCustomer = new JPopupMenu();
        JMenuItem editCustMenuItem = new JMenuItem("Edit", editicon);
        JMenuItem deleteCustMenuItem = new JMenuItem("Delete", deleteicon);
        popupCustomer.add("custPopupEdit", editCustMenuItem);
        popupCustomer.add("custPopupDelete", deleteCustMenuItem);
        popupCustomer.add(new JMenuItem("Cancel", cancelicon));

        //EDIT CUSTOMER HERE
        Map<String, EditCustUI> editcustInstance = new TreeMap<String, EditCustUI>();
        editCustMenuItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                System.out.println("MENU EDIT CLICKED: " + custIDPopupMenu);
                EditCustUI getEditCustUI = editcustInstance.get("editcust" + custIDPopupMenu);
                if (getEditCustUI == null) {
                    EditCustUI newCustUI = new EditCustUI(counterNumber, custIDPopupMenu);
                    editcustInstance.put("editcust" + custIDPopupMenu, newCustUI);
                    newCustUI.setVisible(true);
                    newCustUI.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            if (counterNumber == 1) {
                                displayCustomerToTable(bahagiamall.BahagiaMall.getCounter1());
                            } else if (counterNumber == 2) {
                                displayCustomerToTable(bahagiamall.BahagiaMall.getCounter2());
                            } else if (counterNumber == 3) {
                                displayCustomerToTable(bahagiamall.BahagiaMall.getCounter3());
                            }
                        }

                    });
                } else {
                    getEditCustUI.setVisible(true);
                }
            }
        });

        //DELETE CUSTOMER HERE
        deleteCustMenuItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                System.out.println("MENU DELETE CLICKED: " + custIDPopupMenu);
                Predicate<CustomerInformation> itemCondition = customers -> customers.getCustID().equalsIgnoreCase(custIDPopupMenu);
                if (counterNumber == 1) {
                    bahagiamall.BahagiaMall.getCounter1().removeIf(itemCondition);
                    displayCustomerToTable(bahagiamall.BahagiaMall.getCounter1());
                } else if (counterNumber == 2) {
                    bahagiamall.BahagiaMall.getCounter2().removeIf(itemCondition);
                    displayCustomerToTable(bahagiamall.BahagiaMall.getCounter2());
                } else if (counterNumber == 3) {
                    bahagiamall.BahagiaMall.getCounter3().removeIf(itemCondition);
                    displayCustomerToTable(bahagiamall.BahagiaMall.getCounter3());
                }
            }
        });

        Map<String, ItemUI> itemInstance = new TreeMap<String, ItemUI>();
        customerTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2 && me.getButton() == MouseEvent.BUTTON1) {     // to detect double click events
                    JTable target = (JTable) me.getSource();
                    int row = target.getSelectedRow(); // select a row
                    String getCustIDFromTable = (String) customerTable.getValueAt(row, 0);
                    ItemUI getItemUI = itemInstance.get("item" + getCustIDFromTable);
                    if (getItemUI == null) {
                        ItemUI newItemUI = new ItemUI(getCustIDFromTable, counterNumber);
                        itemInstance.put("item" + getCustIDFromTable, newItemUI);
                        newItemUI.setVisible(true);
                    } else {
                        getItemUI.setVisible(true);
                    }
                }
                if (me.getButton() == MouseEvent.BUTTON3) {
                    int tablepoint = customerTable.rowAtPoint(me.getPoint());
                    if (tablepoint >= 0 && tablepoint < customerTable.getRowCount()) {
                        customerTable.setRowSelectionInterval(tablepoint, tablepoint);
                    } else {
                        customerTable.clearSelection();
                    }
                    JTable target = (JTable) me.getSource();
                    int row = target.getSelectedRow(); // select a row
                    String getCustIDFromTable = (String) customerTable.getValueAt(row, 0);
                    custIDPopupMenu = getCustIDFromTable;
                    popupCustomer.show(me.getComponent(), me.getX(), me.getY());
                }
            }
        });
    }

    ImageIcon logo = new ImageIcon("src/images/mainicon.png");

    private void displayCustomerToTable(LinkedList counter) {
        String currentCustID = "";
        DefaultTableModel customerTableModel = (DefaultTableModel) customerTable.getModel();
        customerTableModel.setRowCount(0);
        //TO CONVERT, NEED TO FILTER CUSTOMER ONLY AND ADD TO NEW LIST
        List<CustomerInformation> convertedCustList = (List<CustomerInformation>) counter.stream().filter(counterdatas -> counterdatas.getClass() == CustomerInformation.class).collect(Collectors.toList());

        int custCount = 0;
        for (Iterator iterator = convertedCustList.iterator(); iterator.hasNext();) {
            CustomerInformation nextCustomerData = (CustomerInformation) iterator.next();
            if (!nextCustomerData.getCustID().equalsIgnoreCase(currentCustID)) {
                currentCustID = nextCustomerData.getCustID();
                custCount++;
                customerTableModel.addRow(new Object[]{nextCustomerData.getCustID(), nextCustomerData.getCustIC(), nextCustomerData.getCustName()});
            }
        }
        countlabelcust.setText(custCount + " Customers");
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
        counterlabel = new javax.swing.JLabel();
        countlabelcust = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(counterNameTitle);
        setIconImage(logo.getImage());

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        counterlabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        counterlabel.setText("Counter 0");

        countlabelcust.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        countlabelcust.setText("0 Customers");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(counterlabel)
                    .addComponent(countlabelcust))
                .addContainerGap(706, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(counterlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(countlabelcust)
                .addContainerGap())
        );

        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer ID", "Customer IC", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(customerTable);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel counterlabel;
    private javax.swing.JLabel countlabelcust;
    private javax.swing.JTable customerTable;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
