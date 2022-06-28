package gui;

import classes.CustomerInformation;
import java.util.Iterator;
import javax.swing.ImageIcon;

public class EditItemUI extends javax.swing.JFrame {

    private String frameEditItemTitle = "";
    private String custID = "";
    private String itemID = "";
    private int counterNumber = 0;

    /**
     * Creates new form EditItemUI
     *
     * @param counterNumber
     * @param custID
     * @param itemID
     */
    public EditItemUI(int counterNumber, String custID, String itemID) {
        this.custID = custID;
        this.itemID = itemID;
        this.counterNumber = counterNumber;
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditItemUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditItemUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditItemUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditItemUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        frameEditItemTitle = "Item " + itemID + " for customer " + custID;
        initComponents();

        //GET OLD DATA AND DISPLAY TO UI
        int index = 0;
        String olditemName = "";
        double olditemPrice = 0;
        String olddatePurchase = "";

        if (counterNumber == 1) {
            for (Iterator iterator = bahagiamall.BahagiaMall.getCounter1().iterator(); iterator.hasNext();) {
                index++;
                CustomerInformation nextCustData = (CustomerInformation) iterator.next();
                if (nextCustData.getCustID().equalsIgnoreCase(custID) && nextCustData.getItemID().equalsIgnoreCase(itemID)) {
                    //GET OLD ITEM DATA
                    olditemName = nextCustData.getItemName();
                    olditemPrice = nextCustData.getitemPrice();
                    olddatePurchase = nextCustData.getDatePurchase();
                }
            }
        } else if (counterNumber == 2) {
            for (Iterator iterator = bahagiamall.BahagiaMall.getCounter2().iterator(); iterator.hasNext();) {
                index++;
                CustomerInformation nextCustData = (CustomerInformation) iterator.next();
                if (nextCustData.getCustID().equalsIgnoreCase(custID) && nextCustData.getItemID().equalsIgnoreCase(itemID)) {
                    //GET OLD ITEM DATA
                    olditemName = nextCustData.getItemName();
                    olditemPrice = nextCustData.getitemPrice();
                    olddatePurchase = nextCustData.getDatePurchase();
                }
            }
        } else if (counterNumber == 3) {
            for (Iterator iterator = bahagiamall.BahagiaMall.getCounter3().iterator(); iterator.hasNext();) {
                index++;
                CustomerInformation nextCustData = (CustomerInformation) iterator.next();
                if (nextCustData.getCustID().equalsIgnoreCase(custID) && nextCustData.getItemID().equalsIgnoreCase(itemID)) {
                    //GET OLD ITEM DATA
                    olditemName = nextCustData.getItemName();
                    olditemPrice = nextCustData.getitemPrice();
                    olddatePurchase = nextCustData.getDatePurchase();
                }
            }
        }

        itemNameEditField.setText(olditemName);
        itemPriceEditField.setText(Double.toString(olditemPrice));
        itemDateEditField.setText(olddatePurchase);

        pack();
        setLocationRelativeTo(null);
        edititemtitle.setText("Edit item " + itemID + " for customer " + custID);
    }

    ImageIcon logo = new ImageIcon("src/images/mainicon.png");

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        edititemtitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        itemNameEditField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        itemPriceEditField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        itemDateEditField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(frameEditItemTitle);
        setIconImage(logo.getImage());

        jPanel2.setBackground(new java.awt.Color(255, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        edititemtitle.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        edititemtitle.setText("Edit item - for customer -");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(edititemtitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(edititemtitle)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel1.setText("Item name:");

        jLabel2.setText("Price:");

        jLabel3.setText("Date Purchased:");

        jButton1.setText("Save");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton2MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemNameEditField)
                            .addComponent(itemPriceEditField)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(itemDateEditField, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 158, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(itemNameEditField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(itemPriceEditField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(itemDateEditField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        //SAVE EDITED ITEM HERE
        String itemName = itemNameEditField.getText();
        double itemPrice = Double.parseDouble(itemPriceEditField.getText());
        String datePurchased = itemDateEditField.getText();

        int index = 0;
        if (counterNumber == 1) {
            for (Iterator iterator = bahagiamall.BahagiaMall.getCounter1().iterator(); iterator.hasNext();) {
                index++;
                CustomerInformation nextCustData = (CustomerInformation) iterator.next();
                if (nextCustData.getCustID().equalsIgnoreCase(custID) && nextCustData.getItemID().equalsIgnoreCase(itemID)) {
                    //GET OLD CUSTOMER DATA
                    String custName = nextCustData.getCustName();
                    String custIC = nextCustData.getCustIC();
                    String counterPaid = nextCustData.getCounterPaid();

                    bahagiamall.BahagiaMall.getCounter1().set(index - 1, new CustomerInformation(custID, custIC, custName, counterPaid, itemID, itemName, itemPrice, datePurchased));
                }
            }
        } else if (counterNumber == 2) {
            for (Iterator iterator = bahagiamall.BahagiaMall.getCounter2().iterator(); iterator.hasNext();) {
                index++;
                CustomerInformation nextCustData = (CustomerInformation) iterator.next();
                if (nextCustData.getCustID().equalsIgnoreCase(custID) && nextCustData.getItemID().equalsIgnoreCase(itemID)) {
                    //GET OLD CUSTOMER DATA
                    String custName = nextCustData.getCustName();
                    String custIC = nextCustData.getCustIC();
                    String counterPaid = nextCustData.getCounterPaid();

                    bahagiamall.BahagiaMall.getCounter2().set(index - 1, new CustomerInformation(custID, custIC, custName, counterPaid, itemID, itemName, itemPrice, datePurchased));
                }
            }
        } else if (counterNumber == 3) {
            for (Iterator iterator = bahagiamall.BahagiaMall.getCounter3().iterator(); iterator.hasNext();) {
                index++;
                CustomerInformation nextCustData = (CustomerInformation) iterator.next();
                if (nextCustData.getCustID().equalsIgnoreCase(custID) && nextCustData.getItemID().equalsIgnoreCase(itemID)) {
                    //GET OLD CUSTOMER DATA
                    String custName = nextCustData.getCustName();
                    String custIC = nextCustData.getCustIC();
                    String counterPaid = nextCustData.getCounterPaid();

                    bahagiamall.BahagiaMall.getCounter3().set(index - 1, new CustomerInformation(custID, custIC, custName, counterPaid, itemID, itemName, itemPrice, datePurchased));
                }
            }
        }
        dispose();
    }//GEN-LAST:event_jButton1MouseReleased

    private void jButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseReleased
        //CANCEL
        dispose();
    }//GEN-LAST:event_jButton2MouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel edititemtitle;
    private javax.swing.JTextField itemDateEditField;
    private javax.swing.JTextField itemNameEditField;
    private javax.swing.JTextField itemPriceEditField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

}
