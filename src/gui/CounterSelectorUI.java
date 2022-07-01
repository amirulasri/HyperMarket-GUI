package gui;

import classes.CustomerInformation;
import classes.ExcelCounterCust;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Queue;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class CounterSelectorUI extends javax.swing.JFrame {

    /**
     * Creates new form CounterSelectorUI
     */
    private ImageIcon logo = new ImageIcon("src/images/mainicon.png");
    private DecimalFormat priceformatter = new DecimalFormat("0.00");

    public CounterSelectorUI() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CounterSelectorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CounterSelectorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CounterSelectorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CounterSelectorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        initComponents();
        countCustomer();
        totalNet();
        pack();
        setLocationRelativeTo(null);
    }

    private void countCustomer() {
        //SET TO GUI
        countlabel1.setText(getCustCount(hypermarket.HyperMarket.getCounter1()) + " Customers");
        countlabel2.setText(getCustCount(hypermarket.HyperMarket.getCounter2()) + " Customers");
        countlabel3.setText(getCustCount(hypermarket.HyperMarket.getCounter3()) + " Customers");

        int totalAllCustomer = getCustCount(hypermarket.HyperMarket.getCounter1()) + getCustCount(hypermarket.HyperMarket.getCounter2()) + getCustCount(hypermarket.HyperMarket.getCounter3());
        totalAllCustLabel.setText("Total customer: " + totalAllCustomer);
    }

    private void totalNet() {
        //CALCULATE AND ADD TO TOTAL
        double totalcounter1 = 0;
        double totalcounter2 = 0;
        double totalcounter3 = 0;

        for (Iterator<CustomerInformation> iterator = hypermarket.HyperMarket.getCounter1().iterator(); iterator.hasNext();) {
            CustomerInformation nextItem = iterator.next();
            totalcounter1 = totalcounter1 + nextItem.getitemPrice();
        }

        for (Iterator<CustomerInformation> iterator = hypermarket.HyperMarket.getCounter2().iterator(); iterator.hasNext();) {
            CustomerInformation nextItem = iterator.next();
            totalcounter2 = totalcounter2 + nextItem.getitemPrice();
        }

        for (Iterator<CustomerInformation> iterator = hypermarket.HyperMarket.getCounter3().iterator(); iterator.hasNext();) {
            CustomerInformation nextItem = iterator.next();
            totalcounter3 = totalcounter3 + nextItem.getitemPrice();
        }

        double totalNet = totalcounter1 + totalcounter2 + totalcounter3;
        String totalNetFormat = priceformatter.format(totalNet);

        netTotalLabel.setText("Net total: RM " + totalNetFormat);
    }

    private int getCustCount(Queue counter) {
        String currentCustID = "";
        int countID = 0;

        for (Iterator iterator = counter.iterator(); iterator.hasNext();) {
            CustomerInformation custNextData = (CustomerInformation) iterator.next();
            if (!custNextData.getCustID().equalsIgnoreCase(currentCustID)) {
                countID++;
                currentCustID = custNextData.getCustID();
            }
        }

        return countID;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        openCounter1Button = new javax.swing.JButton();
        countlabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        openCounter2Button = new javax.swing.JButton();
        countlabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        openCounter3Button = new javax.swing.JButton();
        countlabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        totalAllCustLabel = new javax.swing.JLabel();
        netTotalLabel = new javax.swing.JLabel();
        createReportButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Counter Selector");
        setIconImage(logo.getImage());

        jPanel2.setBackground(new java.awt.Color(220, 156, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/choice.png"))); // NOI18N
        jLabel1.setText("Counter Selector");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("1 - 3 Counter Available");

        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        refreshButton.setText("Refresh");
        refreshButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshButtonMouseClicked(evt);
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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshButton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(refreshButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 247, 151));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel5.setText("Counter 1");

        openCounter1Button.setText("Open Counter");
        openCounter1Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                openCounter1ButtonMouseReleased(evt);
            }
        });

        countlabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        countlabel1.setText("0 Customers");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(countlabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(openCounter1Button)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(openCounter1Button)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(countlabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel3.setBackground(new java.awt.Color(255, 247, 151));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel4.setText("Counter 2");

        openCounter2Button.setText("Open Counter");
        openCounter2Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                openCounter2ButtonMouseReleased(evt);
            }
        });

        countlabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        countlabel2.setText("0 Customers");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(countlabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(openCounter2Button)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(openCounter2Button)
                    .addComponent(countlabel2))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 223, 151));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel3.setText("Counter 3");

        jLabel6.setText("* Customer who buy more than 5 items");

        openCounter3Button.setText("Open Counter");
        openCounter3Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                openCounter3ButtonMouseReleased(evt);
            }
        });

        countlabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        countlabel3.setText("0 Customers");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(0, 216, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(countlabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(openCounter3Button)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(openCounter3Button)
                    .addComponent(countlabel3))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(191, 238, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        totalAllCustLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        totalAllCustLabel.setText("<html>Total customer: 0</html>");

        netTotalLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        netTotalLabel.setText("Net total: RM 0");

        createReportButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excel.png"))); // NOI18N
        createReportButton.setText("Create Report");
        createReportButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createReportButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createReportButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalAllCustLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(netTotalLabel))
                        .addGap(0, 137, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalAllCustLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(netTotalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(createReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private CounterUI counterUI1;
    private CounterUI counterUI2;
    private CounterUI counterUI3;

    private void openCounter1ButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openCounter1ButtonMouseReleased
        //OPEN FOR COUNTER 1
        if (counterUI1 != null) {
            counterUI1.setVisible(true);
        } else {
            counterUI1 = new CounterUI(1);
            counterUI1.setVisible(true);
        }
    }//GEN-LAST:event_openCounter1ButtonMouseReleased

    private void openCounter2ButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openCounter2ButtonMouseReleased
        //OPEN FOR COUNTER 2
        if (counterUI2 != null) {
            counterUI2.setVisible(true);
        } else {
            counterUI2 = new CounterUI(2);
            counterUI2.setVisible(true);
        }
    }//GEN-LAST:event_openCounter2ButtonMouseReleased

    private void openCounter3ButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openCounter3ButtonMouseReleased
        //OPEN FOR COUNTER 3
        if (counterUI3 != null) {
            counterUI3.setVisible(true);
        } else {
            counterUI3 = new CounterUI(3);
            counterUI3.setVisible(true);
        }
    }//GEN-LAST:event_openCounter3ButtonMouseReleased

    private void refreshButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshButtonMouseClicked
        //REFRESH IF ANY CHANGE TO THE QUEUE
        countCustomer();
        totalNet();
    }//GEN-LAST:event_refreshButtonMouseClicked

    //THIS QUEUE/LIST ONLY FOR EXCEL REPORTING
    private Queue excelCounter1 = hypermarket.HyperMarket.getCounter1();
    private Queue excelCounter2 = hypermarket.HyperMarket.getCounter2();
    private Queue excelCounter3 = hypermarket.HyperMarket.getCounter3();
    private void createReportButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createReportButtonMouseClicked
        Object[] options = {"Only unpaid customer",
            "Only paid customer",
            "All customer"};
        int buttonChoose = JOptionPane.showOptionDialog(null,
                "There are 3 option you can choose to create excel report",
                "Choose report option",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]);

        if (buttonChoose == 0) {
            try {
                //CREATE EXCEL FILE HERE
                new ExcelCounterCust(hypermarket.HyperMarket.getCounter1(), hypermarket.HyperMarket.getCounter2(), hypermarket.HyperMarket.getCounter3());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error to save file: " + ex.getMessage(), "Error create excel", HEIGHT);
            }
        } else if (buttonChoose == 1) {
            try {
                //CREATE EXCEL FILE HERE
                new ExcelCounterCust(hypermarket.HyperMarket.getExcelCounter1(), hypermarket.HyperMarket.getExcelCounter2(), hypermarket.HyperMarket.getExcelCounter3());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error to save file: " + ex.getMessage(), "Error create excel", HEIGHT);
            }
        } else if (buttonChoose == 2) {
            try {
                //CREATE EXCEL FILE HERE
                new ExcelCounterCust(excelCounter1, excelCounter2, excelCounter3);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error to save file: " + ex.getMessage(), "Error create excel", HEIGHT);
            }
        }
    }//GEN-LAST:event_createReportButtonMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel countlabel1;
    private javax.swing.JLabel countlabel2;
    private javax.swing.JLabel countlabel3;
    private javax.swing.JButton createReportButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel netTotalLabel;
    private javax.swing.JButton openCounter1Button;
    private javax.swing.JButton openCounter2Button;
    private javax.swing.JButton openCounter3Button;
    private javax.swing.JButton refreshButton;
    private javax.swing.JLabel totalAllCustLabel;
    // End of variables declaration//GEN-END:variables

}
