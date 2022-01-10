package trainREST;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class Full extends ServerResource {
    @Get
    public String toString() {
        String astation = (String) getRequestAttributes().get("astation");
        String dstation = (String) getRequestAttributes().get("dstation");
        String ddate = (String) getRequestAttributes().get("ddate");
        String adate = (String) getRequestAttributes().get("adate");
        String nbrtickets = (String) getRequestAttributes().get("nbrtickets");
        String Tclass = (String) getRequestAttributes().get("class");

        return "The train departing from \"" + astation + "\"  the \"" + ddate	+
                "\" to \"" + dstation + "\" the \"" + adate+
                "\" of class \"" + Tclass +
                "\" with \"" + nbrtickets + "\" tickets left are: <nothing>";
    }
}
