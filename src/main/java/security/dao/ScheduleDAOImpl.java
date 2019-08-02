package security.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import security.model.Schedule;

@Repository
public class ScheduleDAOImpl implements ScheduleDAO{

    @Autowired
    private SessionFactory sessionFactory;
    public void saveSchedule(Schedule schedule) {
        if(schedule.getId() == null){
            sessionFactory.getCurrentSession().persist(schedule);
        } else sessionFactory.getCurrentSession().merge(schedule);
    }
}
