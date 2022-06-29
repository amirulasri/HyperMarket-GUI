package gui;

import classes.CustomerInformation;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CounterUI extends javax.swing.JFrame {

    private String counterNameTitle = "Counter";
    private int counterNumber = 0;

    /**
     * Creates new form CounterUI
     */
    public CounterUI(int counterNumber) {
        this.counterNumber = counterNumber;
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
            }
        });
    }

    ImageIcon logo = new ImageIcon("src/images/mainicon.png");

    private void displayCustomerToTable(Queue counter) {
        String currentCustID = "";
        DefaultTableModel customerTableModel = (DefaultTableModel) customerTable.getModel();
        customerTableModel.setRowCount(0);
        //TO CONVERT, NEED TO FILTER CUSTOMER ONLY AND ADD TO NEW LIST
        List<CustomerInformation> convertedCustList = (List<CustomerInformation>) counter.stream().collect(Collectors.toList());

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
        jButton1 = new javax.swing.JButton();
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

        jButton1.setText("Pay in order");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
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
                        .addComponent(counterlabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(countlabelcust)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(counterlabel)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private PaymentUI paymentui;
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        //PAY PROCESS HERE
        if (paymentui == null) {
            //GET WHO FIRST QUEUE OF CUSTOMER
            CustomerInformation datacust = (CustomerInformation) bahagiamall.BahagiaMall.getCounter1().peek();
            String custIDPay = datacust.getCustID();
            double totalPayment = 0;

            List<CustomerInformation> convertedItemList = null;
            List<CustomerInformation> filteredItemListCust = null;
            if (counterNumber == 1) {
                convertedItemList = (List<CustomerInformation>) bahagiamall.BahagiaMall.getCounter1().stream().collect(Collectors.toList());
                filteredItemListCust = convertedItemList.stream().filter(items -> items.getCustID().equalsIgnoreCase(custIDPay)).collect(Collectors.toList());
            } else if (counterNumber == 2) {
                convertedItemList = (List<CustomerInformation>) bahagiamall.BahagiaMall.getCounter2().stream().collect(Collectors.toList());
                filteredItemListCust = convertedItemList.stream().filter(items -> items.getCustID().equalsIgnoreCase(custIDPay)).collect(Collectors.toList());
            } else if (counterNumber == 3) {
                convertedItemList = (List<CustomerInformation>) bahagiamall.BahagiaMall.getCounter3().stream().collect(Collectors.toList());
                filteredItemListCust = convertedItemList.stream().filter(items -> items.getCustID().equalsIgnoreCase(custIDPay)).collect(Collectors.toList());
            }

            int countitem = 0;
            for (Iterator iterator = filteredItemListCust.iterator(); iterator.hasNext();) {
                CustomerInformation nextItemData = (CustomerInformation) iterator.next();
                countitem++;
                //CALCULATE TOTAL PAYMENT HERE
                totalPayment = totalPayment + nextItemData.getitemPrice();
            }

            paymentui = new PaymentUI(custIDPay, totalPayment, counterNumber, countitem);
            paymentui.setVisible(true);
            paymentui.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (counterNumber == 1) {
                    displayCustomerToTable(bahagiamall.BahagiaMall.getCounter1());
                } else if (counterNumber == 2) {
                    displayCustomerToTable(bahagiamall.BahagiaMall.getCounter2());
                } else if (counterNumber == 3) {
                    displayCustomerToTable(bahagiamall.BahagiaMall.getCounter3());
                }
                paymentui = null;
            }

        });
        } else {
            paymentui.setVisible(true);
        }
    }//GEN-LAST:event_jButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel counterlabel;
    private javax.swing.JLabel countlabelcust;
    private javax.swing.JTable customerTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
