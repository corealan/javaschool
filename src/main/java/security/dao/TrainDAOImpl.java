package security.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import security.model.Schedule;
import security.model.Station;
import security.model.Train;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class TrainDAOImpl implements TrainDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void saveTrain(Train train) {
        if (train.getId() == null) {
            sessionFactory.getCurrentSession().persist(train);
        } else sessionFactory.getCurrentSession().merge(train);
    }

    public Train findTrainById(Long id) {
        Query<Train> query = sessionFactory.getCurrentSession().createQuery("FROM Train t where t.id = :id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public List<Train> getAllTrains() {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Train t");
        return query.list();
    }

    public List<Train> getTrainsBetweenStations(Station a, Station b, Date fromm, Date to) {
        Query<Schedule> query = sessionFactory.getCurrentSession().createQuery("FROM Schedule s where s.station.id = :aId and " +
                "s.departureTime > :aDeparture");
        query.setParameter("aId", a.getId());
        query.setParameter("aDeparture", fromm);

        Query<Schedule> query1 = sessionFactory.getCurrentSession().createQuery("FROM Schedule s where s.station.id = :bId and " +
                "s.arrivalTime < :bArrival");
        query1.setParameter("bId", b.getId());
        query1.setParameter("bArrival", to);

        List<Schedule> schedules1 = query.getResultList(),
                schedules2 = query1.getResultList();
        List<Train> resultTrainList = new ArrayList<Train>();

        System.out.println(schedules1.size() + " " + schedules2.size());
        for(Schedule s1 : schedules1){
         for(Schedule s2 : schedules2){
             if(s1.getTrain().getId() == s2.getTrain().getId()){
                 resultTrainList.add(s1.getTrain());
             }
         }
        }
        return resultTrainList;
    }

}
