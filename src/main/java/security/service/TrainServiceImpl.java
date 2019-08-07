package security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import security.dao.TrainDAO;
import security.model.Schedule;
import security.model.Station;
import security.model.Train;
import security.util.TrainValidator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TrainServiceImpl implements TrainService{

    @Autowired
    private StationService stationService;
    @Autowired
    private TrainDAO trainDAO;

    public String addNewTrain(Map<String, String> params) {

        Train train = new Train();
        train.setTrainNumber(Integer.parseInt(params.get("trainNumber")));
        train.setNumberOfSeats(Integer.parseInt(params.get("numberOfSeats")));
        List<Station> stops = new ArrayList<Station>();
        params.remove("trainNumber");
        params.remove("numberOfSeats");

        for(String s : params.keySet()){
            if(!s.equals("route") && s.matches("\\dstop")) {
                Long id = Long.parseLong(s.substring(0, 1));
                if (!stops.contains(stationService.getStationById(id))) {
                    stops.add(stationService.getStationById(id));
                }
            }
        }

        for (Station station : stops){
            Schedule schedule = new Schedule();
            schedule.setStation(station);
            schedule.setTrain(train);

            Date arrive = null, departure = null;
            for(String s : params.keySet()){
                if(s.equals(station.getId() + "arrive")){

                    if(!params.get(s).equals("")){
                        arrive = getDate(params.get(s));
                    }
                }
                if(s.equals(station.getId() + "departure")){
                    if(!params.get(s).equals("")){
                        departure = getDate(params.get(s));
                    }
                }
            }
            schedule.setArrivalTime(arrive);
            schedule.setDepartureTime(departure);
            train.setRoute(stops);
            train.addSchedule(schedule);
        }

        if(TrainValidator.trainScheduleValidate(train)) {
            trainDAO.saveTrain(train);
        }
        return TrainValidator.getMessage();
    }

    public List<Train> findTrains(Map<String, String> params) {
        Station departure = stationService.getStationByName(params.get("departure"));
        Station arrival = stationService.getStationByName(params.get("destination"));
        Date from = getDate(params.get("after")),
                to = getDate(params.get("before"));
        return trainDAO.getTrainsBetweenStations(departure,arrival,from,to);
    }

    public List<Train> getAllTrains() {
        return trainDAO.getAllTrains();
    }

    public Train findTrainById(Long id) {
        return trainDAO.findTrainById(id);
    }

    private Date getDate(String s){
        s = s.replace("T"," ");
        Date date = null;

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            date = dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
