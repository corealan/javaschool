package security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import security.model.Station;
import security.service.PassengerService;
import security.service.StationService;
import security.service.TicketService;
import security.service.TrainService;

import java.util.Map;

@Controller
public class TicketController {

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private TrainService trainService;

    @Autowired
    private StationService stationService;

    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "/passenger/ticketPurchase/{trainId}/{departure}/{destination}", method = RequestMethod.GET)
    public ModelAndView ticketPurchaseForm(ModelAndView model, @PathVariable("trainId") Long trainId, @PathVariable("departure")Long depId, @PathVariable("destination")Long destId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addObject("train", trainService.findTrainById(trainId));
        model.addObject("departure", stationService.getStationById(depId));
        model.addObject("destination",stationService.getStationById(destId));
        model.addObject("numOfTickets", ticketService.getNumOfTicketsOnSale(trainService.findTrainById(trainId),stationService.getStationById(depId),stationService.getStationById(destId)));
        model.addObject("passenger",passengerService.findByUsername(authentication.getName()));
        model.setViewName("ticketPurchase");
        return model;
    }

    @PostMapping(value = "/passenger/purchaseTicket")
    public ModelAndView purchaseTicket(ModelAndView model, @RequestParam Map<String, String> params){

        model.addObject("message",ticketService.buyTicket(params));
        model.setViewName("passenger");
        return model;
    }
}
