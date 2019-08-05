package security.dao.security;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import security.model.security.Passenger;

@Repository
@Transactional
public class PassengerDAOImpl implements PassengerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void savePassenger(Passenger passenger) {
        sessionFactory.getCurrentSession().persist(passenger);
    }

    public Passenger findByUsername(String username){
        Query<Passenger> query = sessionFactory.getCurrentSession().createQuery("FROM Passenger u where u.username=:username", Passenger.class);
        query.setParameter("username", username);
        return query.uniqueResult();
    }

}
