package trainREST;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class Price extends ServerResource {  
	@Get  
	public String toString() {  
		String price = (String) getRequestAttributes().get("price");
		
		return "The items for \"" + price + "\"  to  bought are: ";  
	}  
	
}  