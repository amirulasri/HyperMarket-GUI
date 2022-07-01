package classes;
public class CustomerInformation {
    private String custID;
    private String custIC;
    private String custName;
    private String counterPaid;
    
    //RELATION WITH ITEMINFORMATION CLASS
    private ItemInformation itemInformation;
    
    public CustomerInformation(String custID, String custIC, String custName, String counterPaid, String itemID, String itemName, double itemPrice, String datePurchase){
        this.itemInformation = new ItemInformation(itemID, itemName, itemPrice, datePurchase, custID);
        this.custID = custID;
        this.custIC = custIC;
        this.custName = custName;
        this.counterPaid = counterPaid;
    }
    
    public String getCustID(){
        return custID;
    }
    
    public String getCustIC(){
        return custIC;
    }
    
    public String getCustName(){
        return custName;
    }
    
    public String getCounterPaid(){
        return counterPaid;
    }
    
    //ITEM PART
    public String getItemID(){
        return itemInformation.getItemID();
    }
    
    public String getItemName(){
        return itemInformation.getItemName();
    }
    
    public double getitemPrice(){
        return itemInformation.getitemPrice();
    }
    
    public String getDatePurchase(){
        return itemInformation.getDatePurchase();
        
    }
}
