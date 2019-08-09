package security.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import security.model.Station;
import security.model.Ticket;
import security.model.Train;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketDAOImpl implements  TicketDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public void saveTicket(Ticket ticket) {
        if(ticket.getId() == null){
            sessionFactory.getCurrentSession().persist(ticket);
        } else sessionFactory.getCurrentSession().merge(ticket);
    }

    public List<Ticket> getAllTickets() {
        Query<Ticket> query = sessionFactory.getCurrentSession().createQuery("FROM Ticket t", Ticket.class);
        return query.getResultList();
    }

    public Ticket getTicketById(Long id) {
        Query<Ticket> query = sessionFactory.getCurrentSession().createQuery("FROM Ticket t WHERE t.id =:id", Ticket.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public List<Ticket> getTicketOnRoute(Train t,Station departure, Station destination) {
        Query<Ticket> query = sessionFactory.getCurrentSession().createQuery("FROM Ticket t WHERE t.departure.id =:departureId AND t.destination.id =:destinationId AND t.train.id=:trainId");
        query.setParameter("trainId", t.getId());
        query.setParameter("departureId", departure.getId());
        query.setParameter("destinationId", destination.getId());
        return query.getResultList();
    }

    public List<Ticket> getTicketsOnTrain(Train train) {
        List<Ticket> ticketsOnTrain = new ArrayList<Ticket>();
        for (Ticket t : getAllTickets()) {
            if (t.getTrain().equals(train)) {
                ticketsOnTrain.add(t);
            }
        }
        return ticketsOnTrain;
    }
}
