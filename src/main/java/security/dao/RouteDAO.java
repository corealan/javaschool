package security.dao;

import org.springframework.stereotype.Repository;
import security.model.Route;

public interface RouteDAO {
    void saveRoute(Route route);
    Route getRouteById(Long id);
}
