package main.java.Repositories;

import main.java.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepositories {
    private Map<String, Ticket> ticketMap=new HashMap<>();

    public Map<String, Ticket> getTicketMap() {
        return ticketMap;
    }

    public void setTicketMap(Map<String, Ticket> ticketMap) {
        this.ticketMap = ticketMap;
    }

    public void save(Ticket ticket)
    {
        ticketMap.put(ticket.getNumber(),ticket);
    }
}
