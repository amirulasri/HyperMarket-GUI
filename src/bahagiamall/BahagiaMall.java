package bahagiamall;

import gui.AddCustomerUI;
import gui.AddItemUI;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import gui.HomeUI;
import java.util.LinkedList;
import java.util.Queue;

public class BahagiaMall {
    
    //ALL QUEUE DATA WILL STORED HERE
    //USING LINKEDLIST IMPLEMENT TO QUEUE
    private static Queue qcounter1 = new LinkedList();
    private static Queue qcounter2 = new LinkedList();
    private static Queue qcounter3 = new LinkedList(); //WHEN ITEM MORE THAN 5
    
    //OBJECT FOR ADD CUST AND ITEM UI
    private static AddCustomerUI addcustui;
    private static AddItemUI additemui;
    
    public static Queue getCounter1(){
        return qcounter1;
    }
    
    public static Queue getCounter2(){
        return qcounter2;
    }
    
    public static Queue getCounter3(){
        return qcounter3;
    }
    
    public static AddCustomerUI getAddCustUI(){
        return addcustui;
    }
    
    public static void createCustomerAddUIInstance(int counterNumber){
        addcustui = new AddCustomerUI(counterNumber);
    }
    
    public static void setCustomerAddUINull(){
        addcustui = null;
    }
    
    public static AddItemUI getAddItemUI(){
        return additemui;
    }
    
    public static void createItemAddUIInstance(int counterNumber, String custID){
        additemui = new AddItemUI(counterNumber, custID);
    }
    
    public static void setItemAddUINull(){
        additemui = null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new HomeUI();
    }
    
    public void outputtoexcel() throws FileNotFoundException, Exception{
        // workbook object
        XSSFWorkbook workbook = new XSSFWorkbook();

        // spreadsheet object
        XSSFSheet spreadsheet = workbook.createSheet(" Student Data ");

        // creating a row object
        XSSFRow row;


        Map<String, Object[]> studentData = new TreeMap<String, Object[]>();

        studentData.put("1", new Object[]{"ID", "NAME"});
        studentData.put("2", new Object[]{"1", "Ainul"});
        studentData.put("3", new Object[]{"2", "Ain"});
        studentData.put("4", new Object[]{"3", "Amy"});
        studentData.put("5", new Object[]{"4", "Putra"});
        Set<String> keyid = studentData.keySet();

        int rowid = 0;

        // writing the data into the sheets...
        for (String key : keyid) {

            System.out.println("Rows: "+rowid);
            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = studentData.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {
                System.out.println("Cells: "+cellid);
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String) obj);
            }
        }

        // .xlsx is the format for Excel Sheets...
        // writing the workbook into the file...
        FileOutputStream out = new FileOutputStream(
                new File("C:\\Users\\amiru\\Downloads\\Test.xlsx"));

        workbook.write(out);
        out.close();
    }
}
