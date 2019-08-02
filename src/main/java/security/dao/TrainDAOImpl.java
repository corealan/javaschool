package security.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import security.model.Train;
@Repository
public class TrainDAOImpl implements TrainDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void saveTrain(Train train) {
        if (train.getId() == null) {
            sessionFactory.getCurrentSession().persist(train);
        } else sessionFactory.getCurrentSession().merge(train);
    }
}
