package security.util;

import security.model.Station;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static List<List<Station>> getSubRoutes(List<Station> route){
        List<List<Station>> subroutes = new ArrayList<List<Station>>();

        for(Station s : route){
            ArrayList<Station> subroute = new ArrayList<Station>();
            int i = route.size();
            while (i > route.indexOf(s) + 1){
                subroutes.add(new ArrayList<Station>(route.subList(route.indexOf(s), i--)));
            }
        }
        return subroutes;
    }
}
