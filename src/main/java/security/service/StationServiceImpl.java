package security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import security.dao.DirectionDAO;
import security.dao.StationDAO;
import security.model.Direction;
import security.model.Station;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
@Service
@Transactional
public class StationServiceImpl implements StationService {

    @Autowired
    StationDAO stationDAO;
    @Autowired
    DirectionDAO directionDAO;

    public void saveStation(Station station) {
        stationDAO.saveStation(station);
    }

    public void saveDirection(Direction direction){
        directionDAO.saveDirection(direction);
    }

    public Station getStationById(long id) {
        return stationDAO.getStationById(id);
    }

    public  Station getStationByName(String name){
        return stationDAO.getStationByName(name);
    }
    public List<Direction> getStationDirections(Station station) {
        return station.getDirections();
    }

    public List<Station> getAllStations() {
        return stationDAO.getAllStations();
    }

    public void addDirectionToStation(Direction direction, Station station) {
        ArrayList<Direction> directions = new ArrayList<Direction>();
        for(Direction d : station.getDirections()){
            directions.add(d);
        }
        directions.add(direction);
        station.setDirections(directions);
        saveStation(station);
    }

    public void addStationToDirection(Station station, Direction direction) {
        direction.addStation(station);
        saveDirection(direction);
    }

    public List<Direction> getDirectionsThroughTwoStations(Station a, Station b) {
        List<Direction> directions = new ArrayList<Direction>();
        for(Direction d : a.getDirections()){
            if(d.containsStation(b)){
                directions.add(d);
            }
        }
        return directions;
    }

    public void addNewStation(String name, String leftNeighbourName, String rightNeighbourName) {
        Station station = new Station();
        station.setName(name);
        if (leftNeighbourName == "" && rightNeighbourName == "") {            //Если у новой станции нет соседей
            Direction direction = new Direction();
            addStationToDirection(station, direction);

        } else if ((leftNeighbourName != "" && rightNeighbourName == "") || (leftNeighbourName == "" && rightNeighbourName != "")) {          //Если у новой станции есть один сосед
            String adjoiningStationName;
            if (rightNeighbourName != "") adjoiningStationName = rightNeighbourName;
            else adjoiningStationName = leftNeighbourName;

            Station adjoiningStation = getStationByName(adjoiningStationName);

            Direction tempDirection = adjoiningStation.getDirections().get(0);

            if (tempDirection.getStations().indexOf(adjoiningStation) == tempDirection.getStations().size() - 1) { //Если станция крайняя в направлении

                List<Direction> tempDirections = adjoiningStation.getDirections();
                for(int i = 0; i < tempDirections.size(); i++){

                    if(getAllStations().contains(getStationByName(name))){
                        addStationToDirection(getStationByName(name), tempDirections.get(i));
                    } else
                        addStationToDirection(station, tempDirections.get(i));
                }

            } else {
                List<Direction> adjoiningStationDirections = adjoiningStation.getDirections();

                for (int j = 0; j < adjoiningStationDirections.size(); j++) {

                    List<Station> adjoiningDirectionStations = adjoiningStationDirections.get(j).getStations();
                    Direction newDirection = new Direction();
                    List<Station> subStations = new LinkedList<Station>(adjoiningDirectionStations.subList(0, adjoiningStationDirections.get(j).getStations().indexOf(adjoiningStation) + 1));
                    for (Station s : subStations) {
                        newDirection.addStation(s);
                    }
                    newDirection.addStation(station);
                    saveDirection(newDirection);

                    newDirection = new Direction();
                    List<Station> subStations1 = new LinkedList<Station>(adjoiningDirectionStations.subList(adjoiningStationDirections.get(j).getStations().indexOf(adjoiningStation), adjoiningDirectionStations.size()));
                    newDirection.addStation(station);
                    for (Station s : subStations1) {
                        newDirection.addStation(s);
                    }
                    saveDirection(newDirection);
                }
            }
        } else if (leftNeighbourName != "" && rightNeighbourName != "") {
            Station a = getStationByName(leftNeighbourName);
            Station b = getStationByName(rightNeighbourName);

            List<Direction> directions = getDirectionsThroughTwoStations(a, b);
            int aIndex = directions.get(0).getStations().indexOf(a),
                    bIndex = directions.get(0).getStations().indexOf(b);

            System.out.println("aIndex = " + aIndex);
            System.out.println("bIndex = " + bIndex);

            if (Math.abs(aIndex - bIndex) == 1) {
                for (Direction d : directions) {
                    if (aIndex > bIndex) {
                        d.insertNewStation(bIndex + 1, station);
                    } else d.insertNewStation(aIndex + 1, station);
                    saveDirection(d);
                }
            }
        }
    }
}
