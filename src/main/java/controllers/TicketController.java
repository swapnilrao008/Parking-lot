package main.java.controllers;

import main.java.Exceptions.GateNotFoundException;
import main.java.Exceptions.ParkingLotNotFoundException;
import main.java.dtos.IssueTicketRequest;
import main.java.dtos.IssueTicketResponse;
import main.java.models.Ticket;
import main.java.services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponse issueTicket(IssueTicketRequest request)
    {
        Ticket ticket= null;
        try {
            ticket = ticketService.issueTicket(request);
        } catch (GateNotFoundException e) {
            System.out.println("Gate not found");
            return new IssueTicketResponse(null,"FAILURE","INVALID GATE");
        } catch (ParkingLotNotFoundException e) {
            System.out.println("parkinng lot not found");
            return new IssueTicketResponse(null,"FAILURE","INVALID PARKING LOT");
        }

        return new IssueTicketResponse(ticket,"SUCCESS","TICKET GENERATED");
    }
}
