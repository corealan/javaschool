package security.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import security.model.Direction;


@Repository
public class DirectionDAOImpl implements DirectionDAO {
    @Autowired
    SessionFactory sessionFactory;


    public void saveDirection(Direction direction) {
        if (direction.getId() == null) {
            sessionFactory.getCurrentSession().persist(direction);
        } else sessionFactory.getCurrentSession().merge(direction);
    }
}
