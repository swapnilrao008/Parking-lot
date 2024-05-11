package main.java.stratergies;

import main.java.Exceptions.ParkingLotFullException;
import main.java.models.*;

public class SimpleParkingSpotAllotmentStratergy implements ParkingSpaceAllotmentStratergy{

    @Override
    public ParkingSpot getParkingSpot(VehicleType vehicleType, ParkingLot parkingLotId) throws ParkingLotFullException {

        for(Floor floor: parkingLotId.getFloors())
        {
            for (ParkingSpot parkingSpot: floor.getParkingSpots())
            {
                if(parkingSpot.getStatus().equals(ParkingSpotStatus.AVAILABLE))
                {
                    if(parkingSpot.getVehicleType().equals(vehicleType))
                    {
                        return parkingSpot;
                    }
                }
            }
        }
        throw new ParkingLotFullException();
    }
}
