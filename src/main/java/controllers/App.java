package main.java.controllers;

import main.java.Repositories.GateRepository;
import main.java.Repositories.ParkingLotRepository;
import main.java.Repositories.TicketRepositories;
import main.java.Repositories.VehicleRepository;
import main.java.dtos.IssueTicketRequest;
import main.java.dtos.IssueTicketResponse;
import main.java.models.*;
import main.java.services.TicketService;
import main.java.stratergies.SimpleParkingSpotAllotmentStratergy;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        Gate gate=new Gate(1, GateType.ENTRY, GateStatus.WORKING);
        Floor floor = new Floor(1);

        for(int i=1;i<=10;i++) {
            floor.getParkingSpots().add(new ParkingSpot(i, VehicleType.FOUR_WHEELER, ParkingSpotStatus.AVAILABLE, floor));
        }
        ArrayList<Floor> floors = new ArrayList<>();
        floors.add(floor);
        ArrayList<Gate> gates=new ArrayList<>();
        gates.add(gate);
        ParkingLot parkingLot = new ParkingLot(1, floors, gates, ParkingLotStatus.ACTIVE);


        GateRepository gateRepository=new GateRepository();
        VehicleRepository vehicleRepository=new VehicleRepository();
        ParkingLotRepository parkingLotRepository=new ParkingLotRepository();
        TicketRepositories ticketRepositories=new TicketRepositories();
        TicketService ticketService = new TicketService(gateRepository,vehicleRepository,parkingLotRepository,ticketRepositories);
        TicketController ticketController = new TicketController(ticketService);
       parkingLotRepository.getParkingLotMap().put(1l,parkingLot);
       gateRepository.getGates().put(1l,gate);
       new IssueTicketRequest(VehicleType.FOUR_WHEELER,1,new SimpleParkingSpotAllotmentStratergy());

        ticketController.issueTicket();

    }
}
