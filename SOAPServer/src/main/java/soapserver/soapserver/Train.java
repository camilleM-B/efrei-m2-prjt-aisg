package soapserver.soapserver;

import java.util.Date;

public class Train {
    public String id;
    public String departureStation;
    public String arrivalStation;
    public Date outboundDate;
    public Date returnDate;
    public Integer totalTickets;
    public Integer remainingTickets;
    public String travelClass;
    public Integer price;

    @Override
    public String toString() {
        return "<h3>Train: " +
                id + "</h3><ul>" +
                "<li>id: " + id + "</li>" +
                "<li>trajectory:<ul>" +
                "<li>departureStation: " + departureStation + " at " + outboundDate + "</li>" +
                "<li>arrivalStation: " + arrivalStation + " at " + returnDate + "</li></ul></li>" +
                "<li>tickets: " + remainingTickets + "/" + totalTickets + " remaining tickets</li>" +
                "<li>travelClass: " + travelClass + "</li>" +
                "<li>price: " + price + "</li></ul></br>";
    }
}
