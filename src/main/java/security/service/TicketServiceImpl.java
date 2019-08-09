package security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import security.dao.TicketDAO;
import security.model.Station;
import security.model.Ticket;
import security.model.Train;
import security.model.security.Passenger;
import security.util.Util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {


    private static final String TOO_LATE = "Нельзя приобрести билет на поезд, до отправлиня которого осталось менее 10 минут.";
    private static final String NOT_ENOUGHT_TICKETS = "Нет доступных для покупки билетов.";
    private static final String ONE_PASSENGER_ONE_TICKET = "Пассажир с такими данными уже зарегистрирован.";
    private static final String SUCCESS = "Билет успешно приобретен!";

    @Autowired
    private TicketDAO ticketDAO;

    @Autowired
    private StationService stationService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TrainService trainService;

    @Autowired
    private PassengerService passengerService;

    public void saveTicket(Ticket ticket) {
        ticketDAO.saveTicket(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketDAO.getAllTickets();
    }

    public Ticket getTicketById(Long id) {
        return ticketDAO.getTicketById(id);
    }

    public List<Ticket> getTicketOnRoute(Train train, Station departure, Station destination) {
        return ticketDAO.getTicketOnRoute(train,departure,destination);
    }

    public int getNumOfTicketsOnSale(Train train, Station departure, Station destination) {
        List<List<Station>> subroutes = Util.getSubRoutes(train.getRoute());
        System.out.println("ROUTE" + train.getRoute());
        for(List<Station> subroute : subroutes){
            System.out.println(subroute);
        }
        int result = train.getNumberOfSeats();

        List<List<Station>> removeList = new ArrayList<List<Station>>();
        for (List<Station> subroute : subroutes) {
            if (subroute.get(0).equals(destination) || subroute.get(subroute.size() - 1).equals(departure) || (!subroute.contains(departure) && !subroute.contains(destination) && !train.getRoute().containsAll(subroute))) {
                removeList.add(subroute);
            }
        }
        subroutes.removeAll(removeList);
        for (List<Station> subroute : subroutes) {
            if(getTicketOnRoute(train,subroute.get(0), subroute.get(subroute.size()-1)).size() != 0)
                System.out.println(subroute);
            result -= getTicketOnRoute(train,subroute.get(0), subroute.get(subroute.size()-1)).size();
        }
        return result;
    }

    public String checkPurchaseConditions(Train train, Station departure, Station destination, Passenger passenger){
        if(getNumOfTicketsOnSale(train, departure, destination) <= 0){
            return NOT_ENOUGHT_TICKETS;
        }
        if(train.getSchedules().get(0).getDepartureTime().getTime() - new Date().getTime() < 600000){
            return TOO_LATE;
        }

        for(Ticket ticket : ticketService.getTicketsOnTrain(train)){
            if(ticket.getPassenger().equals(passenger) && ticket.getTrain().equals(train)){
                return ONE_PASSENGER_ONE_TICKET;
            }
        }

        return SUCCESS;
    }

    public List<Ticket> getTicketsOnTrain(Train train) {
        return ticketDAO.getTicketsOnTrain(train);
    }

    public String buyTicket(Map<String, String> params) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Station departure = stationService.getStationByName(params.get("departureStation")),
                destination = stationService.getStationByName(params.get("destinationStation"));
        Train train = trainService.findTrainById(Long.parseLong(params.get("trainId")));
        Passenger passenger = passengerService.findByUsername(authentication.getName());
        String conditions = checkPurchaseConditions(train,departure,destination, passenger);
        if(conditions.equals(SUCCESS)){
            Ticket ticket = new Ticket();
            ticket.setTrain(train);
            ticket.setDeparture(departure);
            ticket.setDestination(destination);
            ticket.setPassenger(passengerService.findByUsername(authentication.getName()));
            saveTicket(ticket);
        }
        return conditions;
    }
}
