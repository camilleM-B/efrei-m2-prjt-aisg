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
        float ticketsPercentage = remainingTickets.floatValue() / totalTickets.floatValue();
        String cssColorTickets = ticketsPercentage < 0.10 ? "red" : "black";
        String cssColorAvailable = remainingTickets <= 0 ? "gray; text-decoration: wavy line-through red" : "black";
        String cssColorGrayedOut = remainingTickets <= 0 ? "gray" : "black";
        cssColorTickets = cssColorGrayedOut.equals("gray") ? "gray" : cssColorTickets;
        String htmlSoldOut = remainingTickets <= 0 ? " (Sold out)" : "";

        return "<h3 style=\"color:" + cssColorAvailable + ";\" id=\"" + id + "\">Train: " +
                id + htmlSoldOut + "</h3><ul>" +
                "<li style=\"color:" + cssColorGrayedOut + ";\">id: " + id + "</li>" +
                "<li style=\"color:" + cssColorGrayedOut + ";\">trajectory:<ul>" +
                "<li style=\"color:" + cssColorGrayedOut + ";\">departureStation: " + departureStation + " at " + outboundDate + "</li>" +
                "<li style=\"color:" + cssColorGrayedOut + ";\">arrivalStation: " + arrivalStation + " at " + returnDate + "</li></ul></li>" +
                "<li style=\"color:" + cssColorTickets + ";\"> tickets: " + remainingTickets + "/" + totalTickets + " remaining tickets</li>" +
                "<li style=\"color:" + cssColorGrayedOut + ";\">travelClass: " + travelClass + "</li>" +
                "<li style=\"color:" + cssColorGrayedOut + ";\">price: " + price + "</li></ul></br>";
    }
}
