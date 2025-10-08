package parkingLot;

public class CarSpot extends ParkingSpot {
    CarSpot(String spotId){
        super(spotId, SpotType.COMPACT);
    }
}
