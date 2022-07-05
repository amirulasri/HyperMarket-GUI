package gui;

import com.google.common.io.Files;
import java.io.BufferedReader;
import java.io.EOFException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import classes.*;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HomeUI extends javax.swing.JFrame {

    /**
     * Creates new form HomeUI
     */
    public HomeUI() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        initComponents();
        pack();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private ImageIcon logo = new ImageIcon("src/images/mainicon.png");

    private CounterSelectorUI counterSelectorUI;

    //TEMPORARY BEFORE ASSIGN COUNTER NUMBER AUTOMATICALLY
    private ArrayList<CustomerInformation> customerList = new ArrayList();
    private ArrayList<String> listCustID = new ArrayList<String>();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        importbutton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        displaydatabutton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home - HyperMarket");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(logo.getImage());

        jPanel1.setBackground(new java.awt.Color(252, 156, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mainuiicon.png"))); // NOI18N
        jLabel1.setText("HyperMarket");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Collaboration with Nurul Ain, Nurin Ainul, Amymelinda, Putra, Amirul Asri");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));

        jPanel2.setBackground(new java.awt.Color(33, 181, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        importbutton.setBackground(new java.awt.Color(153, 204, 255));
        importbutton.setText("Import Data");
        importbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                importbuttonMouseReleased(evt);
            }
        });
        importbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importbuttonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        jLabel3.setText("<html>Import new data from <br>.txt file. Makesure each data <br>separated with comma (,)</html>");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/import.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(importbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(importbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(33, 181, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        displaydatabutton.setBackground(new java.awt.Color(204, 255, 204));
        displaydatabutton.setText("Display Stored Data");
        displaydatabutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                displaydatabuttonMouseReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        jLabel4.setText("<html>Display all stored data <br>in 3 counters available on <br>this application</html>");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dashboard.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(displaydatabutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(displaydatabutton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText("Welcome!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(352, 352, 352)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void importbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importbuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_importbuttonActionPerformed

    //GET ONLY SELECTED ITEM BY CUSTOMER ID TO ADD TO COUNTER
    private List filteritemdatacust(String custID) {
        Predicate<CustomerInformation> itemSelectCondition = itemsCond -> itemsCond.getCustID().equalsIgnoreCase(custID);
        List itemsCustomer = customerList.stream().filter(itemSelectCondition).collect(Collectors.toList());
        return itemsCustomer;
    }

    private void importtxtFile(File selectedFile) {
        importbutton.setEnabled(false);
        //1. READ TEXTFILE AND ADD TO TEMPORARY ARRAY
        try {
            BufferedReader br = new BufferedReader(new FileReader(selectedFile));
            String line = br.readLine();

            String customerID = "";
            String customerIC = "";
            String customerName = "";

            while (line != null) {
                
                //READ DATA EACH LINE
                StringTokenizer st = new StringTokenizer(line, ",");

                //DETECT IF LINE FOR CUSTOMER OR ITEM DATA
                String type = st.nextToken();
                if (type.equalsIgnoreCase("customer")) {
                    customerID = st.nextToken();
                    customerIC = st.nextToken();
                    customerName = st.nextToken();
                    listCustID.add(customerID);

                } else if (type.equalsIgnoreCase("item")) {
                    String itemID = st.nextToken();
                    String itemName = st.nextToken();
                    double itemPrice = Double.parseDouble(st.nextToken());
                    String custID = st.nextToken();
                    //VERIFY ITEM CUSTOMER
                    if (!custID.equalsIgnoreCase(customerID)) {
                        System.out.println("INVALID ITEM FOR CUSTOMER: " + customerID);
                    }
                    String datePurchase = st.nextToken();

                    customerList.add(new CustomerInformation(customerID, customerIC, customerName, "", itemID, itemName, itemPrice, datePurchase));
                }

                line = br.readLine();
            }
            br.close();

            //2. READ TEMP ARRAY AND ADD TO EVERY QUEUE COUNTER
            int counterswitching = 1;
            for (int i = 0; i < listCustID.size(); i++) {
                //GET LIST ITEMS FROM TEMP ARRAY ITEM FILTER BY CUSTOMER ID
                List filtereditemcustomer = filteritemdatacust(listCustID.get(i));

                if (filtereditemcustomer.size() <= 5) {
                    if (counterswitching == 1) {
                        for (int j = 0; j < filtereditemcustomer.size(); j++) {
                            CustomerInformation itemdata = (CustomerInformation) filtereditemcustomer.get(j);
                            String custID = itemdata.getCustID();
                            String custIC = itemdata.getCustIC();
                            String custName = itemdata.getCustName();
                            String itemID = itemdata.getItemID();
                            String itemName = itemdata.getItemName();
                            Double itemPrice = itemdata.getItemPrice();
                            String datePurchased = itemdata.getDatePurchase();

                            hypermarket.HyperMarket.getCounter1().add(new CustomerInformation(custID, custIC, custName, "counter1", itemID, itemName, itemPrice, datePurchased));
                        }
                        counterswitching = 2;
                    } else if (counterswitching == 2) {
                        for (int j = 0; j < filtereditemcustomer.size(); j++) {
                            CustomerInformation itemdata = (CustomerInformation) filtereditemcustomer.get(j);
                            String custID = itemdata.getCustID();
                            String custIC = itemdata.getCustIC();
                            String custName = itemdata.getCustName();
                            String itemID = itemdata.getItemID();
                            String itemName = itemdata.getItemName();
                            Double itemPrice = itemdata.getItemPrice();
                            String datePurchased = itemdata.getDatePurchase();

                            hypermarket.HyperMarket.getCounter2().add(new CustomerInformation(custID, custIC, custName, "counter2", itemID, itemName, itemPrice, datePurchased));

                        }
                        counterswitching = 1;
                    }
                } else {
                    for (int j = 0; j < filtereditemcustomer.size(); j++) {
                        CustomerInformation itemdata = (CustomerInformation) filtereditemcustomer.get(j);
                        String custID = itemdata.getCustID();
                        String custIC = itemdata.getCustIC();
                        String custName = itemdata.getCustName();
                        String itemID = itemdata.getItemID();
                        String itemName = itemdata.getItemName();
                        Double itemPrice = itemdata.getItemPrice();
                        String datePurchased = itemdata.getDatePurchase();

                        hypermarket.HyperMarket.getCounter3().add(new CustomerInformation(custID, custIC, custName, "counter3", itemID, itemName, itemPrice, datePurchased));

                    }
                }
            }

            //OPEN COUNTER SELECTOR UI
            counterSelectorUI = new CounterSelectorUI();
            counterSelectorUI.setVisible(true);
        } catch (EOFException ex) {
            JOptionPane.showMessageDialog(null, "Error while importing txt file. Error: " + ex.getMessage(), "Error importing txt file", JOptionPane.ERROR_MESSAGE);
            System.out.println("End of file error");
            System.exit(0);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error while importing txt file. Error: " + ex.getMessage(), "Error importing txt file", JOptionPane.ERROR_MESSAGE);
            System.out.println("File not found");
            System.exit(0);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error while importing txt file. Error: " + ex.getMessage(), "Error importing txt file", JOptionPane.ERROR_MESSAGE);
            System.out.println("Wrong input!!!");
            System.exit(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error while importing txt file. Error: " + e.getMessage(), "Error importing txt file", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    

    private void opentxtFile(JFileChooser selectedtxt) {
        selectedtxt.setFileFilter(new FileNameExtensionFilter(".txt file", "txt"));
        int result = selectedtxt.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = selectedtxt.getSelectedFile();
            String filePath = selectedFile.toString();
            String extension = Files.getFileExtension(filePath);
            if (extension.equalsIgnoreCase("txt")) {
                importtxtFile(selectedFile);
            } else {
                JOptionPane.showMessageDialog(null, "The file must be in .txt format", "Invalid file extension", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private JFileChooser txtfilechooser;
    private void importbuttonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_importbuttonMouseReleased
        //IMPORT FILE PROCESS HERE
        if (!importbutton.isEnabled()) {
            return;
        }
        txtfilechooser = new JFileChooser();
        opentxtFile(txtfilechooser);
    }//GEN-LAST:event_importbuttonMouseReleased

    private void displaydatabuttonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displaydatabuttonMouseReleased
        //JUST OPEN IF FILE IMPORTED
        if (counterSelectorUI == null) {
            JOptionPane.showMessageDialog(null, "Please import data using .txt file by clicking button (Import Data)", "No data imported", JOptionPane.ERROR_MESSAGE);
        } else {
            counterSelectorUI.setVisible(true);
        }
    }//GEN-LAST:event_displaydatabuttonMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton displaydatabutton;
    private javax.swing.JButton importbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables

}
