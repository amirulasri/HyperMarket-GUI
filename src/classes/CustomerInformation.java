package classes;
public class CustomerInformation {
    private String custID;
    private String custIC;
    private String custName;
    private String counterPaid;
    
    //RELATION WITH ITEMINFORMATION CLASS
    private ItemInformation itemInformation;
    
    public CustomerInformation(){
        this.itemInformation = new ItemInformation();
        this.custID = null;
        this.custIC = null;
        this.custName = null;
        this.counterPaid = null;
    }
    
    public CustomerInformation(String custID, String custIC, String custName, String counterPaid, String itemID, String itemName, double itemPrice, String datePurchase){
        this.itemInformation = new ItemInformation(itemID, itemName, itemPrice, datePurchase, custID);
        this.custID = custID;
        this.custIC = custIC;
        this.custName = custName;
        this.counterPaid = counterPaid;
    }
    
    public void setCustID(String custID){
        this.custID = custID;
    }
    
    public void setCustIC(String custIC){
        this.custIC = custIC;
    }
    
    public void setCustName(String custName){
        this.custName = custName;
    }
    
    public void setCounterPaid(String counterPaid){
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
    public void setItemID(String itemID){
        itemInformation.setItemID(itemID);
    }
    
    public void setItemName(String itemName){
        itemInformation.setItemName(itemName);
    }
    
    public void setItemPrice(double itemPrice){
        itemInformation.setItemPrice(itemPrice);
    }
    
    public void setDatePurchase(String datePurchase){
        itemInformation.setDatePurchase(datePurchase);
        
    }
    
    public String getItemID(){
        return itemInformation.getItemID();
    }
    
    public String getItemName(){
        return itemInformation.getItemName();
    }
    
    public double getItemPrice(){
        return itemInformation.getItemPrice();
    }
    
    public String getDatePurchase(){
        return itemInformation.getDatePurchase();
        
    }
    
    public String itemGetCustID(){
        return itemInformation.getCustID();
    }
    
    @Override
    public String toString(){
        return "Customer ID: " + custID + "\nCustomer name: " + custName + "\nCustomer IC: " + custIC + "\nCounter Paid: " + counterPaid + "\nItem ID: " + getItemID() + "\nItem name: " + getItemName() + "\nPrice: " + getItemPrice() + "\nDate purchased: " + getDatePurchase() + "\nCustomer item ID: " + itemGetCustID();
    }
}
