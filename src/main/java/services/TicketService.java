package main.java.services;

import main.java.Exceptions.GateNotFoundException;
import main.java.Exceptions.ParkingLotNotFoundException;
import main.java.Repositories.GateRepository;
import main.java.Repositories.ParkingLotRepository;
import main.java.Repositories.TicketRepositories;
import main.java.Repositories.VehicleRepository;
import main.java.dtos.IssueTicketRequest;
import main.java.models.*;
import main.java.stratergies.ParkingSpaceAllotmentStratergy;

import java.util.Date;
import java.util.UUID;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepositories ticketRepositories;

    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository, ParkingLotRepository parkingLotRepository, TicketRepositories ticketRepositories) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepositories = ticketRepositories;
    }

    public Ticket issueTicket(IssueTicketRequest request) throws GateNotFoundException, ParkingLotNotFoundException {
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());
        Gate gate = gateRepository.findGateById(request.getGateId());
        ticket.setGate(gate);
        Vehicle vehicle = vehicleRepository.getVehicleByNumber(request.getVehicleNumber());
        if(vehicle==null)
        {
            vehicle = new Vehicle(request.getVehicleNumber(), request.getVehicleType(), request.getOwner());
            vehicleRepository.save(vehicle);
        }
        ticket.setVehicle(vehicle);
        ParkingLot parkingLot = parkingLotRepository.getParkingLotById(request.getParkingLotId());
        ParkingSpaceAllotmentStratergy parkingSpaceAllotmentStratergy = request.getParkingSpaceAllotmentStratergy();
        ParkingSpot parkingSpot = parkingSpaceAllotmentStratergy.getParkingSpot(request.getVehicleType(), request.getParkingLotId());
        ticket.setParkingSpot(parkingSpot);
        ticket.setNumber(request.getVehicleNumber()+ UUID.randomUUID());
        ticketRepositories.save(ticket);
        return ticket;

    }
}
