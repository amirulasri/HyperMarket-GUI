package classes;
public class CustomerInformation {
    private String custID;
    private String custIC;
    private String custName;
    private String counterPaid;
    
    public CustomerInformation(String custID, String custIC, String custName, String counterPaid){
        this.custID = custID;
        this.custIC = custIC;
        this.custName = custName;
        this.counterPaid = counterPaid;
    }
    
    public CustomerInformation(String custID, String custIC, String custName){
        this.custID = custID;
        this.custIC = custIC;
        this.custName = custName;
        this.counterPaid = null;
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
}