package security.dao;

import security.model.Station;
import security.model.Train;

import java.util.Date;
import java.util.List;

public interface TrainDAO {
    void saveTrain(Train train);
    Train findTrainById(Long id);
    List<Train> getAllTrains();
    List<Train> getTrainsBetweenStations(Station a, Station b, Date from, Date to);
    Train findTrainByNumber(Integer number);

}
