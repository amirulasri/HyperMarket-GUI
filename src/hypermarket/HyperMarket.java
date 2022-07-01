package hypermarket;

import gui.AddCustomerUI;
import gui.AddItemUI;
import gui.HomeUI;
import java.util.LinkedList;
import java.util.Queue;

public class HyperMarket {
    
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
        new HomeUI().setVisible(true);
    }
}
