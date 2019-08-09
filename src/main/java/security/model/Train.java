package security.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "train_number")
    private Integer trainNumber;

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderBy(value = "departureTime")
    private List<Schedule> schedules;

    @OrderBy(value = "schedules")
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Station> route;

    @Column(name = "number_of_seats")
    private Integer numberOfSeats;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Train train = (Train) o;

        if (!id.equals(train.id)) return false;
        if (!trainNumber.equals(train.trainNumber)) return false;
        if (!schedules.equals(train.schedules)) return false;
        if (!route.equals(train.route)) return false;
        return numberOfSeats.equals(train.numberOfSeats);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + trainNumber.hashCode();
        result = 31 * result + schedules.hashCode();
        result = 31 * result + route.hashCode();
        result = 31 * result + numberOfSeats.hashCode();
        return result;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void addSchedule(Schedule schedule){
        schedules.add(schedule);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public Integer getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(Integer trainNumber) {
        this.trainNumber = trainNumber;
    }

    public List<Station> getRoute() {
        List<Station> route = new ArrayList<Station>();
        for(Schedule schedule: schedules){
            route.add(schedule.getStation());
        }
        return route;
    }

    public void setRoute(List<Station> route) {
        this.route = route;
    }

    public Train() {
        schedules = new ArrayList<Schedule>();
    }
}
