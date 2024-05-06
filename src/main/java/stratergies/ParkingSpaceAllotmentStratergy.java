package main.java.stratergies;

import main.java.models.ParkingSpot;
import main.java.models.VehicleType;

public interface ParkingSpaceAllotmentStratergy {

    ParkingSpot getParkingSpot(VehicleType vehicleType,Long parkingLotId);
}
