package restserver.restserver;

import java.net.HttpURLConnection;
import java.net.URL;

import org.restlet.Component;
import org.restlet.data.Protocol;

public class RestDistributor {
 
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Component component = new Component();  
		component.getServers().add(Protocol.HTTP, 8189); 
 
		// Attach the application to the component and start it  
		component.getDefaultHost().attach(new RouterApplication());  
		component.start();  
		
	}	 
 
}