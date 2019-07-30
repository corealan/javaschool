package security.dao.security;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import security.model.security.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public void saveUser(User user) {
        sessionFactory.getCurrentSession().persist(user);
    }

    public User findByUsername(String username){
        Query<User> query = sessionFactory.getCurrentSession().createQuery("FROM User u where u.username=:username", User.class);
        query.setParameter("username", username);
        return query.uniqueResult();
    }

}
