package parkingLot;

public abstract class Vehicle {
    private String licensePlateNumber;
    private VehicleType type;

    public Vehicle(String number, VehicleType type){
        this.type = type;
        licensePlateNumber = number;
    }

    public String getLicensePlateNumber(){
        return licensePlateNumber;
    }
    public VehicleType getVehicleType(){
        return type;
    }
}
