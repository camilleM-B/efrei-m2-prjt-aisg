package trainREST;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class Station extends ServerResource {  
	@Get  
	public String toString() {  
		String astation = (String) getRequestAttributes().get("astation");
		String dstation = (String) getRequestAttributes().get("dstation");

		return "The items from \"" + astation + "\"  to \"" + dstation + "\" bought are: <nothing>";  
	}  
}  
