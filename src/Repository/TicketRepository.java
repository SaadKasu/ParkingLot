package Repository;

import Models.Ticket;

import java.util.HashMap;
import java.util.Optional;

public class TicketRepository {
    private HashMap<Long, Ticket> ticketHashMap = new HashMap<>();
    private long id = 0;
    public Optional<Ticket> saveTicketToDB(Ticket ticket){
        ticket.setId(String.valueOf(++id));
        ticketHashMap.put(Long.valueOf(ticket.id), ticket);

        return Optional.of(ticket);
    }
}
