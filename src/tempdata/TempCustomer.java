package tempdata;
public class TempCustomer {
    private String custID;
    private String custIC;
    private String custName;
    private String counterPaid;
    
    public TempCustomer(String custID, String custIC, String custName, String counterPaid){
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
}
