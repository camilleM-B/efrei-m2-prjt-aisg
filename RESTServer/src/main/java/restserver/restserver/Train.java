package restserver.restserver;

import java.util.Date;

public class Train {
    public String id;
    public String departureStation;
    public String arrivalStation;
    public String outboundDate;
    public String returnDate;
    public long totalTickets;
    public long remainingTickets;
    public String travelClass;
    public long price;
    
    public void display() {
    	 System.out.println("id "+id+" \r dstation" + departureStation + "\r price "+ price);
    }
    
    public String displayString() {
   	 return ("id "+id+" \r dstation" + departureStation + "\r price "+ price);
   }
    
        
    public Train(String id, String departureStation, String arrivalStation, String outboundDate, String returnDate, long totalTickets
    , long remainingTickets, String travelClass, long price) {
    	
    	this.id = id;
    	this.departureStation  = departureStation;
    	this.arrivalStation = arrivalStation;
    	this.outboundDate = outboundDate;
    	this.returnDate = returnDate;
    	this.totalTickets = totalTickets;
    	this.remainingTickets = remainingTickets;
    	this.travelClass = travelClass;
    	this.price = price;
    }
    
    public long getPrice() {return this.price;}
    public String getId() {return this.id;}
}