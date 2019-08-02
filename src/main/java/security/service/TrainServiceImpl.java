package security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import security.dao.ScheduleDAO;
import security.dao.TrainDAO;
import security.model.Schedule;
import security.model.Station;
import security.model.Train;

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
    private ScheduleDAO scheduleDAO;
    @Autowired
    private TrainDAO trainDAO;

    public void addNewTrain(Map<String, String> params) {

        Train train = new Train();
        train.setTrainNumber(10);
        List<Station> stops = new ArrayList<Station>();

        for(String s : params.keySet()){
            Long id = Long.parseLong(s.substring(0,1));
            if(!stops.contains(stationService.getStationById(id))) {
                stops.add(stationService.getStationById(id));
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
            train.addSchedule(schedule);
        }
        trainDAO.saveTrain(train);
    }

    private Date getDate(String s){
        s = s.replace("T"," ");
        Date date = null;
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm");
        try {
            date = dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
