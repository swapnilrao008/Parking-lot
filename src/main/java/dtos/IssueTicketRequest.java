package main.java.dtos;

import main.java.models.VehicleType;
import main.java.stratergies.ParkingSpaceAllotmentStratergy;

public class IssueTicketRequest {
    private VehicleType vehicleType;
    private String vehicleNumber;
    private String owner;
    private long gateId;
    private long parkingLotId;
    private ParkingSpaceAllotmentStratergy parkingSpaceAllotmentStratergy;

    public IssueTicketRequest(VehicleType vehicleType, long gateId, long parkingLotId, ParkingSpaceAllotmentStratergy parkingSpaceAllotmentStratergy) {
        this.vehicleType = vehicleType;
        this.gateId = gateId;
        this.parkingLotId = parkingLotId;
        this.parkingSpaceAllotmentStratergy = parkingSpaceAllotmentStratergy;
    }

    public ParkingSpaceAllotmentStratergy getParkingSpaceAllotmentStratergy() {
        return parkingSpaceAllotmentStratergy;
    }

    public void setParkingSpaceAllotmentStratergy(ParkingSpaceAllotmentStratergy parkingSpaceAllotmentStratergy) {
        this.parkingSpaceAllotmentStratergy = parkingSpaceAllotmentStratergy;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public long getGateId() {
        return gateId;
    }

    public void setGateId(long gateId) {
        this.gateId = gateId;
    }

    public long getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(long parkingLotId) {
        this.parkingLotId = parkingLotId;
    }
}
