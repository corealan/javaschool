package security.validators;

import security.model.Schedule;
import security.model.Train;

import java.util.Date;
import java.util.List;

public class trainValidator {
    private static String message;
    public static boolean trainScheduleValidate(Train train){
        List<Schedule> trainSchedules = train.getSchedules();

        if(trainSchedules.get(0).getArrivalTime() != null){
            message = "По станции отправления не должно быть задано время прибытия!";
            return false;
        }
        if(trainSchedules.get(trainSchedules.size()-1).getDepartureTime() != null){
            message = "По конечной станции не должно быть задано время отправления!";
            return false;
        }
        if(trainSchedules.get(0).getDepartureTime().after(trainSchedules.get(1).getArrivalTime())){
            message = "Некорректно заданы времена прибытия/отправления!";
            return false;
        }
        System.out.println(trainSchedules.size());
        for(int i = 1; i < trainSchedules.size()-1; i++){
            boolean arrivalBeforeDeparture = trainSchedules.get(i+1).getArrivalTime().before(trainSchedules.get(i).getDepartureTime());
            boolean departureBeforeArrival = trainSchedules.get(i).getDepartureTime().before(trainSchedules.get(i).getArrivalTime());

            if(arrivalBeforeDeparture || departureBeforeArrival){
                message = "Некорректно заданы времена прибытия/отправления!";
                return false;
            }
        }


        for(Schedule schedule : trainSchedules) {
            List<Schedule> stationSchedules = schedule.getStation().getSchedules();

            for (Schedule schedule1 : stationSchedules) {
                    if (schedule1.getArrivalTime() != null && schedule.getArrivalTime() != null && schedule1.getArrivalTime().compareTo(schedule.getArrivalTime()) == 0) {
                        message = "В заданное время на станцию " + schedule.getStation().getName() + " прибывает поезд №" +
                                schedule1.getTrain().getTrainNumber();
                        return false;
                    } else if (schedule.getDepartureTime() != null && schedule1.getDepartureTime() != null && schedule1.getDepartureTime().compareTo(schedule.getDepartureTime()) == 0) {
                        message = "АХ ТЫ КРИВАЯ СУКА!!! У ЛАРЬКОВ БЛЯТЬ ПОНАБЕРУТ!!!!В заданное время cо станции " + schedule.getStation().getName() + " отправляется поезд №" +
                                schedule1.getTrain().getTrainNumber();
                        return false;
                    }

            }
        }

        message = null;
        return true;
    }

    public static String getMessage() {
        return message;
    }
}
