package security.service;

import security.model.Train;

import java.util.List;
import java.util.Map;

public interface TrainService {
    String addNewTrain(Map<String, String> params);
    List<Train> findTrains(Map<String, String> params);
    List<Train> getAllTrains();
    Train findTrainById(Long id);
    Train findTrainByNumber(Integer number);
}
