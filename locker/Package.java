package locker;

public class Package {
    private String packageId;
    private LockerSize size;
    private String customerNumber;
    public Package(String id, LockerSize size, String number){
        packageId = id;
        this.size = size;
        customerNumber = number;
    }
    public String getPackageId(){
        return packageId;
    }
    public LockerSize getLockerSize(){
        return size;
    }
    public String getCustomerNumber(){
        return customerNumber;
    }
}
