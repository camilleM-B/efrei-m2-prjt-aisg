package restserver.restserver;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;
//import sun.security.krb5.internal.Ticket;

public class RouterApplication extends Application{
	/**
	 * Creates a root Restlet that will receive all incoming calls.
	 */
	@Override
	public synchronized Restlet createInboundRoot() {
		// Create a router Restlet that routes each call to a new respective instance of resource.
		Router router = new Router(getContext());
		// Defines routes
		//router.attach("/{dstation}/{astation}/{ddate}/{adate}/{nbrtickets}/{class}", Full.class);
		router.attach("/station/{dstation}/{astation}", Station.class);
		router.attach("/class/{class}", Tclass.class);
		router.attach("/ticket/{nbrtickets}", Ticket.class);
		router.attach("/price/{price}", Price.class);
		router.attach("/train", Train.class);
		router.attach("/reservation/{id}", Reservation.class);


		return router;
	}


}