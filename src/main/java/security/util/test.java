package security.util;

import security.model.Station;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<Station> route = new ArrayList<Station>();
        Station a = new Station();
        a.setName("A");
        Station b = new Station();
        b.setName("B");
        Station c = new Station();
        c.setName("C");
        Station d = new Station();
        d.setName("D");
        Station e = new Station();
        e.setName("E");

        route.add(a);
        route.add(b);
        route.add(c);
        route.add(d);
        route.add(e);

        List<List<Station>> subroutes = Util.getSubRoutes(route);
        for(List<Station> subroute : subroutes){
            for(Station s : subroute){
                System.out.print(s.getName());
            }
            System.out.println();

        }
    }
}
