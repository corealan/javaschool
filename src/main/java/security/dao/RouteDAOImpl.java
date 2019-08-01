package security.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import security.model.Route;

@Repository
public class RouteDAOImpl implements RouteDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void saveRoute(Route route) {
        sessionFactory.getCurrentSession().persist(route);
    }

    public Route getRouteById(Long id) {
        Query<Route> query = sessionFactory.getCurrentSession().createQuery("FROM Route r where r.id=:id", Route.class);
        query.setParameter("id", id);
        return query.uniqueResult();
    }
}
