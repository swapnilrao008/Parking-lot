package main.java.stratergies;

import main.java.Exceptions.ParkingLotFullException;
import main.java.models.ParkingLot;
import main.java.models.ParkingSpot;
import main.java.models.VehicleType;

public interface ParkingSpaceAllotmentStratergy {

    ParkingSpot getParkingSpot(VehicleType vehicleType, ParkingLot parkingLot) throws ParkingLotFullException;
}
