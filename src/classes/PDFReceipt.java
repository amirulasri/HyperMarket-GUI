package classes;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.Cell;
import be.quodlibet.boxable.HorizontalAlignment;
import be.quodlibet.boxable.Row;
import be.quodlibet.boxable.VerticalAlignment;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Queue;

public class PDFReceipt {

    public PDFReceipt(String name, String custID, String custIC, double totalPrice, double amountpay, int totalItems, int counterNumber, Queue itemList, String paymenttype) throws IOException {
        DecimalFormat priceformatter = new DecimalFormat("#0.00");
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PDFReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PDFReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PDFReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PDFReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime datetimenow = LocalDateTime.now();
        
        String paymentmethodtext = "";
        if (paymenttype.equalsIgnoreCase("credit")) {
            paymentmethodtext = "Credit Card";
        } else if (paymenttype.equalsIgnoreCase("debit")) {
            paymentmethodtext = "Debit";
        } else {
            paymentmethodtext = "Cash";
        }

        // CREATE NEW PDF DOCUMENT
        PDDocument document = new PDDocument();

        // Retrieving the pages of the document
        PDPage page = new PDPage();
        document.addPage(page);

        page = document.getPage(0);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        PDImageXObject logoimage = PDImageXObject.createFromFile("src/images/mainicon.png", document);
        contentStream.drawImage(logoimage, 25, 730, 45, 45);

        // ADD TITLE STORE
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 30);
        contentStream.newLineAtOffset(74, 738);
        contentStream.showText("HyperMarket");
        contentStream.endText();

        // ADD CUSTOMER NAME TITLE
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 11);
        contentStream.newLineAtOffset(35, 700);
        contentStream.showText("Name: ");
        contentStream.endText();

        // ADD CUSTOMER NAME GET FROM RECEIPT CLASS
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 11);
        contentStream.newLineAtOffset(110, 700);
        contentStream.showText(name);
        contentStream.endText();

        // ADD CUST ID TITLE
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 11);
        contentStream.newLineAtOffset(35, 685);
        contentStream.showText("Customer ID: ");
        contentStream.endText();

        // ADD CUST ID GET FROM RECEIPT CLASS
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 11);
        contentStream.newLineAtOffset(110, 685);
        contentStream.showText(custID);
        contentStream.endText();

        // ADD CUST IC TITLE
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 11);
        contentStream.newLineAtOffset(35, 670);
        contentStream.showText("IC number: ");
        contentStream.endText();

        // ADD CUST IC FROM RECEIPT CLASS
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 11);
        contentStream.newLineAtOffset(110, 670);
        contentStream.showText(custIC);
        contentStream.endText();

        // ADD ITEMS TITLE
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 11);
        contentStream.newLineAtOffset(35, 655);
        contentStream.showText("Total items: ");
        contentStream.endText();

        // ADD ITEMS GET FROM RECEIPT CLASS
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 11);
        contentStream.newLineAtOffset(110, 655);
        contentStream.showText(String.valueOf(totalItems));
        contentStream.newLine();
        contentStream.endText();

        // ADD COUNTER NUMBER TITLE
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 11);
        contentStream.newLineAtOffset(400, 700);
        contentStream.showText("Counter number: ");
        contentStream.endText();

        // ADD COUNTER NUMBER
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 11);
        contentStream.newLineAtOffset(485, 700);
        contentStream.showText(String.valueOf(counterNumber));
        contentStream.endText();

        // ADD RECEIPT DATE TITLE
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 11);
        contentStream.newLineAtOffset(400, 685);
        contentStream.showText("Receipt date: ");
        contentStream.endText();

        // ADD RECEIPT DATE
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 11);
        contentStream.newLineAtOffset(485, 685);
        contentStream.showText(String.valueOf(dtf.format(datetimenow)));
        contentStream.endText();

        // ADD PAYMENT TYPE TITLE
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 11);
        contentStream.newLineAtOffset(400, 670);
        contentStream.showText("Payment type: ");
        contentStream.endText();

        // ADD PAYMENT TYPE GET FROM RECEIPT CLASS
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 11);
        contentStream.newLineAtOffset(485, 670);
        contentStream.showText(paymentmethodtext);
        contentStream.endText();

        // Closing the content stream
        contentStream.close();

        // Initialize table
        float margin = 40;
        float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
        float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
        float bottomMargin = 0;

        BaseTable table = new BaseTable(600, yStartNewPage, bottomMargin, tableWidth, margin, document, page, true,
                true);

        // Create Header row
        Row<PDPage> headerRow = table.createRow(15f);
        Cell<PDPage> cell = headerRow.createCell(100, "Items Added");
        cell.setFontSize(12);
        cell.setFont(PDType1Font.HELVETICA_BOLD);
        cell.setFillColor(new Color(244, 255, 199));
        table.addHeaderRow(headerRow);
        Row<PDPage> row = table.createRow(10f);
        cell = row.createCell(7, "No.");
        cell.setFont(PDType1Font.HELVETICA_BOLD);
        cell.setFillColor(new Color(255, 161, 255));
        cell = row.createCell(58, "Item name");
        cell.setFont(PDType1Font.HELVETICA_BOLD);
        cell.setFillColor(new Color(255, 161, 255));
        cell = row.createCell(20, "Price");
        cell.setFont(PDType1Font.HELVETICA_BOLD);
        cell.setFillColor(new Color(255, 161, 255));
        cell = row.createCell(15, "Date Purchased");
        cell.setFont(PDType1Font.HELVETICA_BOLD);
        cell.setFillColor(new Color(255, 161, 255));
        Color itemcolor = new Color(130, 255, 249);

        // loop through the result set
        int i = 0;
        for (Iterator iterator = itemList.iterator(); iterator.hasNext();) {
            CustomerInformation nextItemData = (CustomerInformation)iterator.next();
            i++;
            Row<PDPage> row1 = table.createRow(10f);
            cell = row1.createCell(7, i + ".");
            cell.setFillColor(itemcolor);
            cell = row1.createCell(58, nextItemData.getItemName());
            cell.setFillColor(itemcolor);
            cell = row1.createCell(20, "RM " + priceformatter.format(nextItemData.getitemPrice()));
            cell.setFillColor(itemcolor);
            cell = row1.createCell(15, nextItemData.getDatePurchase());
            cell.setFillColor(itemcolor);
        }

        // ROW FOR TOTAL PRICE
        Row<PDPage> row2 = table.createRow(17f);
        cell = row2.createCell(65, "Total");
        cell.setFontSize(10);
        cell.setValign(VerticalAlignment.get("center"));
        cell.setAlign(HorizontalAlignment.get("right"));
        cell.setFillColor(new Color(231, 199, 255));
        cell = row2.createCell(35, "RM " + priceformatter.format(totalPrice));
        cell.setFontSize(10);
        cell.setValign(VerticalAlignment.get("center"));
        cell.setFillColor(new Color(231, 199, 255));

        // SPACING NULL ROW
        Row<PDPage> rownull = table.createRow(13f);
        cell = rownull.createCell(100, "");
        cell.setBorderStyle(null);

        // CUSTOMER PAY ROW
        Row<PDPage> row4 = table.createRow(17f);
        cell = row4.createCell(75, "Customer pay:");
        cell.setFont(PDType1Font.HELVETICA);
        cell.setFontSize(11);
        cell.setValign(VerticalAlignment.get("bottom"));
        cell.setAlign(HorizontalAlignment.get("right"));
        cell.setBorderStyle(null);
        cell = row4.createCell(25, "RM " + priceformatter.format(amountpay));
        cell.setValign(VerticalAlignment.get("bottom"));
        cell.setFont(PDType1Font.HELVETICA);
        cell.setFontSize(11);
        cell.setBorderStyle(null);

        // CUSTOMER PAY ROW
        Row<PDPage> row5 = table.createRow(17f);
        cell = row5.createCell(75, "Balance:");
        cell.setFont(PDType1Font.HELVETICA);
        cell.setFontSize(11);
        cell.setValign(VerticalAlignment.get("bottom"));
        cell.setAlign(HorizontalAlignment.get("right"));
        cell.setBorderStyle(null);
        cell = row5.createCell(25, "RM " + priceformatter.format(amountpay - totalPrice));
        cell.setValign(VerticalAlignment.get("bottom"));
        cell.setFont(PDType1Font.HELVETICA);
        cell.setFontSize(11);
        cell.setBorderStyle(null);

        table.draw();

        JFrame saveframe = new JFrame();
        saveframe.setIconImage(new ImageIcon(PDFReceipt.class.getResource("/images/mainicon.png")).getImage());
        JFileChooser fileChooser = new JFileChooser() {
            /**
             *
             */
            private static final long serialVersionUID = -894233845899825024L;

            public void approveSelection() {

                File file = getSelectedFile();
                String filestring = file.toString();

                String[] left_side_of_dot = filestring.split("\\.");

                file = new File(left_side_of_dot[0] + ".pdf");

                if (file.exists() && getDialogType() == SAVE_DIALOG) {
                    int result = JOptionPane.showConfirmDialog(saveframe, "The file exists, overwrite?",
                            "Existing file", JOptionPane.YES_NO_CANCEL_OPTION);
                    switch (result) {
                        case JOptionPane.YES_OPTION:
                            super.approveSelection();
                            return;
                        case JOptionPane.NO_OPTION:
                            return;
                        case JOptionPane.CLOSED_OPTION:
                            return;
                        case JOptionPane.CANCEL_OPTION:
                            cancelSelection();
                            return;
                    }
                }
                super.approveSelection();
            }
        };
        fileChooser.setDialogTitle("Save Receipt PDF file");
        fileChooser.setSelectedFile(new File("Receipt Bahagia Mall " + custID));
        fileChooser.setFileFilter(new FileNameExtensionFilter("pdf file", "pdf"));
        int userSelection = fileChooser.showSaveDialog(saveframe);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            // CHECK IF EXISTS
            String filename = fileChooser.getSelectedFile().toString();
            if (!filename.endsWith(".pdf")) {
                filename += ".pdf";
                fileToSave = new File(filename);
                document.save(new File(fileToSave.getAbsolutePath()));
            }

        }

        // Closing the document
        document.close();
    }
}
