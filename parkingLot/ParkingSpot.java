package parkingLot;

public abstract class ParkingSpot {
    private String spotId;
    private SpotType spotType;
    private boolean isOccupied;
    private Vehicle vehicle;

    ParkingSpot(String id, SpotType type){
        spotId = id;
        spotType = type;
        isOccupied = false;
    }
    public String getSpotId() { return spotId; }
    public SpotType getType() { return spotType; }
    public boolean isOccupied() { return isOccupied; }
    public Vehicle getVehicle() { return vehicle; }

    public synchronized boolean assignVehicle(Vehicle vehicle){
        if (!isOccupied) {
            this.vehicle = vehicle;
            this.isOccupied = true;
            return true;
        }
        return false;
    }

    public synchronized boolean removeVehicle(){
        if(isOccupied){
            this.vehicle = null;
            this.isOccupied = false;
            return true;
        }
        return true;
    }
}
