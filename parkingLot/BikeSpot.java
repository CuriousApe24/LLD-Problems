package parkingLot;

public class BikeSpot extends ParkingSpot {
    BikeSpot(String spotId){
        super(spotId, SpotType.MOTORCYCLE);
    }
}
