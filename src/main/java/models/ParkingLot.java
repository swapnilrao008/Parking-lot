package main.java.models;

import java.util.List;

public class ParkingLot {
    private long id;
   private List<Floor> floors;
   private List<Gate> gates;
   private ParkingLotStatus parkingLotStatus;

    public ParkingLot(long id, List<Floor> floors, List<Gate> gates, ParkingLotStatus parkingLotStatus) {
        this.id = id;
        this.floors = floors;
        this.gates = gates;
        this.parkingLotStatus = parkingLotStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public ParkingLotStatus getParkingStatus() {
        return parkingLotStatus;
    }

    public void setParkingStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }
}
