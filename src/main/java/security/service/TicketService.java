package security.service;

import security.model.Station;
import security.model.Ticket;
import security.model.Train;
import security.model.security.Passenger;

import java.util.List;
import java.util.Map;

public interface TicketService {
    void saveTicket(Ticket ticket);
    List<Ticket> getAllTickets();
    Ticket getTicketById(Long id);
    List<Ticket> getTicketOnRoute(Train train,Station departure, Station destination);
    String checkPurchaseConditions(Train train, Station departure, Station destination, Passenger passenger);
    public int getNumOfTicketsOnSale(Train t, Station departure, Station destination);
    List<Ticket> getTicketsOnTrain(Train train);
    String buyTicket(Map<String, String> params);

}
