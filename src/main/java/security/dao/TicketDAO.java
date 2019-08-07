package security.dao;

import security.model.Station;
import security.model.Ticket;
import security.model.Train;

import java.util.List;

public interface TicketDAO {
    void saveTicket(Ticket ticket);
    List<Ticket> getAllTickets();
    Ticket getTicketById(Long id);
    List<Ticket> getTicketOnRoute(Train t,Station departure, Station destination);
    List<Ticket> getTicketsOnTrain(Train train);
}
