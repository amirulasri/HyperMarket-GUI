package classes;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Queue;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.SAVE_DIALOG;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelCounterCust {

    public ExcelCounterCust(Queue counter1, Queue counter2, Queue counter3) throws FileNotFoundException, Exception {
        DecimalFormat priceformatter = new DecimalFormat("#0.00");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
        LocalDateTime datetimenow = LocalDateTime.now();

        // workbook object
        XSSFWorkbook workbook = new XSSFWorkbook();

        // spreadsheet object
        XSSFSheet spreadsheet;

        // CREATE STYLING FOR ROW ITEMS HEADER
        XSSFColor coloritemheader = new XSSFColor(new Color(150, 255, 253), null);
        XSSFCellStyle stylecellitemheader = workbook.createCellStyle();
        stylecellitemheader.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        stylecellitemheader.setBorderBottom(BorderStyle.MEDIUM);
        stylecellitemheader.setBorderTop(BorderStyle.MEDIUM);
        stylecellitemheader.setBorderRight(BorderStyle.MEDIUM);
        stylecellitemheader.setBorderLeft(BorderStyle.MEDIUM);
        stylecellitemheader.setFillForegroundColor(coloritemheader);

        // CREATE STYLING FOR ROW ITEMS LIST
        XSSFColor coloritemlist = new XSSFColor(new Color(254, 179, 255), null);
        XSSFCellStyle stylecellitemlist = workbook.createCellStyle();
        stylecellitemlist.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        stylecellitemlist.setBorderBottom(BorderStyle.MEDIUM);
        stylecellitemlist.setBorderTop(BorderStyle.MEDIUM);
        stylecellitemlist.setBorderRight(BorderStyle.MEDIUM);
        stylecellitemlist.setBorderLeft(BorderStyle.MEDIUM);
        stylecellitemlist.setFillForegroundColor(coloritemlist);

        // CREATE STYLING FOR BAHAGIA MALL TITLE
        XSSFColor colortitle = new XSSFColor(new Color(179, 255, 252), null);
        XSSFCellStyle stylecelltitle = workbook.createCellStyle();
        stylecelltitle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        stylecelltitle.setFillForegroundColor(colortitle);
        Font fonttitle = workbook.createFont();
        fonttitle.setFontHeightInPoints((short) 20);
        stylecelltitle.setFont(fonttitle);

        // CREATE STYLING FOR REPORT PART
        XSSFColor colorreport = new XSSFColor(new Color(238, 255, 153), null);
        XSSFCellStyle stylecellreport = workbook.createCellStyle();
        stylecellreport.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        stylecellreport.setFillForegroundColor(colorreport);
        Font fontreport = workbook.createFont();
        fontreport.setFontHeightInPoints((short) 15);
        stylecellreport.setFont(fontreport);

        // CREATE STYLING FOR HEADER REPORT
        XSSFColor colorheaderreport = new XSSFColor(new Color(150, 255, 253), null);
        XSSFCellStyle stylecellheaderreport = workbook.createCellStyle();
        stylecellheaderreport.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        stylecellheaderreport.setFillForegroundColor(colorheaderreport);
        Font fontheaderreport = workbook.createFont();
        fontheaderreport.setFontHeightInPoints((short) 18);
        stylecellheaderreport.setFont(fontheaderreport);

        //ADD LOGO
        //FileInputStream obtains input bytes from the image file
        InputStream inputStream = new FileInputStream("src/images/mainicon.png");
        byte[] bytes = IOUtils.toByteArray(inputStream);
        int pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
        inputStream.close();
        CreationHelper helper = workbook.getCreationHelper();
        Drawing drawing;
        ClientAnchor anchor;
        Picture bahagiamalllogo;

        //CREATE FOR COUNTER 1
        spreadsheet = workbook.createSheet("Counter 1");
        spreadsheet.setColumnWidth(1, 8000);
        spreadsheet.setColumnWidth(2, 4000);
        spreadsheet.setColumnWidth(3, 5000);
        // creating a row object
        XSSFRow row;

        //Creates the top-level drawing patriarch.
        drawing = spreadsheet.createDrawingPatriarch();

        //Create an anchor that is attached to the worksheet
        anchor = helper.createClientAnchor();

        //create an anchor with upper left cell _and_ bottom right cell
        anchor.setCol1(0); //Column B
        anchor.setRow1(1); //Row 2
        anchor.setCol2(2); //Column C
        anchor.setRow2(3); //Row 4

        //Creates a picture
        bahagiamalllogo = drawing.createPicture(anchor, pictureIdx);
        bahagiamalllogo.resize(0.32, 2);

        int rowid;
        rowid = 5;
        Cell cell;
        spreadsheet.addMergedRegion(new CellRangeAddress(3, 3, 1, 4));//MERGE CELL
        row = spreadsheet.createRow(3);
        cell = row.createCell(1);
        cell.setCellValue("              HyperMarket - Counter 1");
        cell.setCellStyle(stylecelltitle);

        String currentCustID = "";
        //CREATE DATA IN EXCEL SHEET 1 - COUNTER 1
        for (Iterator<CustomerInformation> iterator = counter1.iterator(); iterator.hasNext();) {
            int cellid = 0;
            CustomerInformation nextCustomerData = iterator.next();

            //CREATE TABLE FOR CUSTOMER DATA
            if (!nextCustomerData.getCustID().equalsIgnoreCase(currentCustID)) {
                spreadsheet.createRow(rowid++);
                row = spreadsheet.createRow(rowid++);
                spreadsheet.addMergedRegion(new CellRangeAddress(rowid - 1, rowid - 1, cellid, cellid + 1));//MERGE CELL
                cell = row.createCell(cellid++);
                cell.setCellValue("Customer ID: " + nextCustomerData.getCustID());
                row = spreadsheet.createRow(rowid++);
                cellid = 0;
                spreadsheet.addMergedRegion(new CellRangeAddress(rowid - 1, rowid - 1, cellid, cellid + 1));//MERGE CELL
                cell = row.createCell(cellid++);
                cell.setCellValue("Customer Name: " + nextCustomerData.getCustName());
                row = spreadsheet.createRow(rowid++);
                cellid = 0;
                spreadsheet.addMergedRegion(new CellRangeAddress(rowid - 1, rowid - 1, cellid, cellid + 1));//MERGE CELL
                cell = row.createCell(cellid++);
                cell.setCellValue("Customer IC: " + nextCustomerData.getCustIC());

                currentCustID = nextCustomerData.getCustID();

                cellid = 0;
                //CREATE DATA ITEMS TABLE HEADER FOR EVERY CUSTOMER
                row = spreadsheet.createRow(rowid++);
                cell = row.createCell(cellid++);
                cell.setCellValue("Item ID");
                cell.setCellStyle(stylecellitemheader);
                cell = row.createCell(cellid++);
                cell.setCellValue("Item Name");
                cell.setCellStyle(stylecellitemheader);
                cell = row.createCell(cellid++);
                cell.setCellValue("Item Price");
                cell.setCellStyle(stylecellitemheader);
                cell = row.createCell(cellid++);
                cell.setCellValue("Date Purchased");
                cell.setCellStyle(stylecellitemheader);
            }

            //LOOP EVERY ITEMS DATA UNDER ITEM TABLE HEADER
            cellid = 0;
            row = spreadsheet.createRow(rowid++);
            cell = row.createCell(cellid++);
            cell.setCellValue(nextCustomerData.getItemID());
            cell.setCellStyle(stylecellitemlist);
            cell = row.createCell(cellid++);
            cell.setCellValue(nextCustomerData.getItemName());
            cell.setCellStyle(stylecellitemlist);
            cell = row.createCell(cellid++);
            cell.setCellValue("RM " + priceformatter.format(nextCustomerData.getitemPrice()));
            cell.setCellStyle(stylecellitemlist);
            cell = row.createCell(cellid++);
            cell.setCellValue(nextCustomerData.getDatePurchase());
            cell.setCellStyle(stylecellitemlist);
        }

        //CREATE FOR COUNTER 2
        spreadsheet = workbook.createSheet("Counter 2");
        spreadsheet.setColumnWidth(1, 8000);
        spreadsheet.setColumnWidth(2, 4000);
        spreadsheet.setColumnWidth(3, 5000);

        //Creates the top-level drawing patriarch.
        drawing = spreadsheet.createDrawingPatriarch();

        //Create an anchor that is attached to the worksheet
        anchor = helper.createClientAnchor();

        //create an anchor with upper left cell _and_ bottom right cell
        anchor.setCol1(0); //Column B
        anchor.setRow1(1); //Row 2
        anchor.setCol2(2); //Column C
        anchor.setRow2(3); //Row 4

        //Creates a picture
        bahagiamalllogo = drawing.createPicture(anchor, pictureIdx);
        bahagiamalllogo.resize(0.32, 2);

        rowid = 5;
        spreadsheet.addMergedRegion(new CellRangeAddress(3, 3, 1, 4));//MERGE CELL
        row = spreadsheet.createRow(3);
        cell = row.createCell(1);
        cell.setCellValue("              HyperMarket - Counter 2");
        cell.setCellStyle(stylecelltitle);

        //CREATE DATA IN EXCEL SHEET 2 - COUNTER 2
        for (Iterator<CustomerInformation> iterator = counter2.iterator(); iterator.hasNext();) {
            int cellid = 0;
            CustomerInformation nextCustomerData = iterator.next();

            //CREATE TABLE FOR CUSTOMER DATA
            if (!nextCustomerData.getCustID().equalsIgnoreCase(currentCustID)) {
                spreadsheet.createRow(rowid++);
                row = spreadsheet.createRow(rowid++);
                spreadsheet.addMergedRegion(new CellRangeAddress(rowid - 1, rowid - 1, cellid, cellid + 1));//MERGE CELL
                cell = row.createCell(cellid++);
                cell.setCellValue("Customer ID: " + nextCustomerData.getCustID());
                row = spreadsheet.createRow(rowid++);
                cellid = 0;
                spreadsheet.addMergedRegion(new CellRangeAddress(rowid - 1, rowid - 1, cellid, cellid + 1));//MERGE CELL
                cell = row.createCell(cellid++);
                cell.setCellValue("Customer Name: " + nextCustomerData.getCustName());
                row = spreadsheet.createRow(rowid++);
                cellid = 0;
                spreadsheet.addMergedRegion(new CellRangeAddress(rowid - 1, rowid - 1, cellid, cellid + 1));//MERGE CELL
                cell = row.createCell(cellid++);
                cell.setCellValue("Customer IC: " + nextCustomerData.getCustIC());

                currentCustID = nextCustomerData.getCustID();

                cellid = 0;
                //CREATE DATA ITEMS TABLE HEADER FOR EVERY CUSTOMER
                row = spreadsheet.createRow(rowid++);
                cell = row.createCell(cellid++);
                cell.setCellValue("Item ID");
                cell.setCellStyle(stylecellitemheader);
                cell = row.createCell(cellid++);
                cell.setCellValue("Item Name");
                cell.setCellStyle(stylecellitemheader);
                cell = row.createCell(cellid++);
                cell.setCellValue("Item Price");
                cell.setCellStyle(stylecellitemheader);
                cell = row.createCell(cellid++);
                cell.setCellValue("Date Purchased");
                cell.setCellStyle(stylecellitemheader);
            }

            //LOOP EVERY ITEMS DATA UNDER ITEM TABLE HEADER
            cellid = 0;
            row = spreadsheet.createRow(rowid++);
            cell = row.createCell(cellid++);
            cell.setCellValue(nextCustomerData.getItemID());
            cell.setCellStyle(stylecellitemlist);
            cell = row.createCell(cellid++);
            cell.setCellValue(nextCustomerData.getItemName());
            cell.setCellStyle(stylecellitemlist);
            cell = row.createCell(cellid++);
            cell.setCellValue("RM " + priceformatter.format(nextCustomerData.getitemPrice()));
            cell.setCellStyle(stylecellitemlist);
            cell = row.createCell(cellid++);
            cell.setCellValue(nextCustomerData.getDatePurchase());
            cell.setCellStyle(stylecellitemlist);
        }

        //CREATE FOR COUNTER 3
        spreadsheet = workbook.createSheet("Counter 3");
        spreadsheet.setColumnWidth(1, 8000);
        spreadsheet.setColumnWidth(2, 4000);
        spreadsheet.setColumnWidth(3, 5000);

        //Creates the top-level drawing patriarch.
        drawing = spreadsheet.createDrawingPatriarch();

        //Create an anchor that is attached to the worksheet
        anchor = helper.createClientAnchor();

        //create an anchor with upper left cell _and_ bottom right cell
        anchor.setCol1(0); //Column B
        anchor.setRow1(1); //Row 2
        anchor.setCol2(2); //Column C
        anchor.setRow2(3); //Row 4

        //Creates a picture
        bahagiamalllogo = drawing.createPicture(anchor, pictureIdx);
        bahagiamalllogo.resize(0.32, 2);

        rowid = 5;
        spreadsheet.addMergedRegion(new CellRangeAddress(3, 3, 1, 4));//MERGE CELL
        row = spreadsheet.createRow(3);
        cell = row.createCell(1);
        cell.setCellValue("              HyperMarket - Counter 3");
        cell.setCellStyle(stylecelltitle);

        //CREATE DATA IN EXCEL SHEET 3 - COUNTER 3
        for (Iterator<CustomerInformation> iterator = counter3.iterator(); iterator.hasNext();) {
            int cellid = 0;
            CustomerInformation nextCustomerData = iterator.next();

            //CREATE TABLE FOR CUSTOMER DATA
            if (!nextCustomerData.getCustID().equalsIgnoreCase(currentCustID)) {
                spreadsheet.createRow(rowid++);
                row = spreadsheet.createRow(rowid++);
                spreadsheet.addMergedRegion(new CellRangeAddress(rowid - 1, rowid - 1, cellid, cellid + 1));//MERGE CELL
                cell = row.createCell(cellid++);
                cell.setCellValue("Customer ID: " + nextCustomerData.getCustID());
                row = spreadsheet.createRow(rowid++);
                cellid = 0;
                spreadsheet.addMergedRegion(new CellRangeAddress(rowid - 1, rowid - 1, cellid, cellid + 1));//MERGE CELL
                cell = row.createCell(cellid++);
                cell.setCellValue("Customer Name: " + nextCustomerData.getCustName());
                row = spreadsheet.createRow(rowid++);
                cellid = 0;
                spreadsheet.addMergedRegion(new CellRangeAddress(rowid - 1, rowid - 1, cellid, cellid + 1));//MERGE CELL
                cell = row.createCell(cellid++);
                cell.setCellValue("Customer IC: " + nextCustomerData.getCustIC());

                currentCustID = nextCustomerData.getCustID();

                cellid = 0;
                //CREATE DATA ITEMS TABLE HEADER FOR EVERY CUSTOMER
                row = spreadsheet.createRow(rowid++);
                cell = row.createCell(cellid++);
                cell.setCellValue("Item ID");
                cell.setCellStyle(stylecellitemheader);
                cell = row.createCell(cellid++);
                cell.setCellValue("Item Name");
                cell.setCellStyle(stylecellitemheader);
                cell = row.createCell(cellid++);
                cell.setCellValue("Item Price");
                cell.setCellStyle(stylecellitemheader);
                cell = row.createCell(cellid++);
                cell.setCellValue("Date Purchased");
                cell.setCellStyle(stylecellitemheader);
            }

            //LOOP EVERY ITEMS DATA UNDER ITEM TABLE HEADER
            cellid = 0;
            row = spreadsheet.createRow(rowid++);
            cell = row.createCell(cellid++);
            cell.setCellValue(nextCustomerData.getItemID());
            cell.setCellStyle(stylecellitemlist);
            cell = row.createCell(cellid++);
            cell.setCellValue(nextCustomerData.getItemName());
            cell.setCellStyle(stylecellitemlist);
            cell = row.createCell(cellid++);
            cell.setCellValue("RM " + priceformatter.format(nextCustomerData.getitemPrice()));
            cell.setCellStyle(stylecellitemlist);
            cell = row.createCell(cellid++);
            cell.setCellValue(nextCustomerData.getDatePurchase());
            cell.setCellStyle(stylecellitemlist);
        }

        //CREATE REPORTING
        spreadsheet = workbook.createSheet("Report");
        //Creates the top-level drawing patriarch.
        drawing = spreadsheet.createDrawingPatriarch();

        //Create an anchor that is attached to the worksheet
        anchor = helper.createClientAnchor();

        //create an anchor with upper left cell _and_ bottom right cell
        anchor.setCol1(0); //Column B
        anchor.setRow1(1); //Row 2
        anchor.setCol2(2); //Column C
        anchor.setRow2(3); //Row 4

        //Creates a picture
        bahagiamalllogo = drawing.createPicture(anchor, pictureIdx);
        bahagiamalllogo.resize(0.76, 2);

        rowid = 5;
        spreadsheet.addMergedRegion(new CellRangeAddress(3, 3, 1, 7));//MERGE CELL
        row = spreadsheet.createRow(3);
        cell = row.createCell(1);
        cell.setCellValue("              HyperMarket - Report");
        cell.setCellStyle(stylecelltitle);

        //CALCULATE NUMBER OF CUSTOMER
        int totalAllCustomer = getCustCount(hypermarket.HyperMarket.getCounter1()) + getCustCount(hypermarket.HyperMarket.getCounter2()) + getCustCount(hypermarket.HyperMarket.getCounter3());

        //CALCULATE NET TOTAL
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

        //CALCULATE EACH COUNTER NET TOTAL
        row = spreadsheet.createRow(8);
        spreadsheet.addMergedRegion(new CellRangeAddress(8, 8, 1, 6));//MERGE CELL
        cell = row.createCell(1);
        cell.setCellValue("Total customer from all counter");
        cell.setCellStyle(stylecellheaderreport);
        row = spreadsheet.createRow(9);
        spreadsheet.addMergedRegion(new CellRangeAddress(9, 9, 1, 6));//MERGE CELL
        cell = row.createCell(1);
        cell.setCellValue(String.valueOf(totalAllCustomer) + " Customers");
        cell.setCellStyle(stylecellreport);

        row = spreadsheet.createRow(12);
        spreadsheet.addMergedRegion(new CellRangeAddress(12, 12, 1, 6));//MERGE CELL
        cell = row.createCell(1);
        cell.setCellValue("Net total from all counter");
        cell.setCellStyle(stylecellheaderreport);
        row = spreadsheet.createRow(13);
        spreadsheet.addMergedRegion(new CellRangeAddress(13, 13, 1, 6));//MERGE CELL
        cell = row.createCell(1);
        cell.setCellValue("RM " + totalNetFormat);
        cell.setCellStyle(stylecellreport);

        JFrame saveframe = new JFrame();
        saveframe.setIconImage(new ImageIcon(PDFReceipt.class.getResource("/images/mainicon.png")).getImage());
        JFileChooser fileChooser = new JFileChooser() {
            /**
             *
             */
            private static final long serialVersionUID = -894233845899825024L;

            @Override
            public void approveSelection() {

                File file = getSelectedFile();
                String filestring = file.toString();

                String[] left_side_of_dot = filestring.split("\\.");

                file = new File(left_side_of_dot[0] + ".xlsx");

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
        fileChooser.setDialogTitle("Save Report Excel file");
        fileChooser.setSelectedFile(new File("Counter Bahagia Mall Report " + dtf.format(datetimenow)));
        fileChooser.setFileFilter(new FileNameExtensionFilter("xlsx file", "xlsx"));
        int userSelection = fileChooser.showSaveDialog(saveframe);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            // CHECK IF EXISTS
            String filename = fileChooser.getSelectedFile().toString();
            if (!filename.endsWith(".xlsx")) {
                filename += ".xlsx";
                fileToSave = new File(filename);
                FileOutputStream excelout = new FileOutputStream(new File(fileToSave.getAbsolutePath()));
                workbook.write(excelout);
                excelout.close();
            }
        }
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
}
