package soapserver.soapserver;

import java.io.*;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private List<Train> trains;
    private Trains trainsObj;

    public void init() {
        message = "SNCF on the way!";
        trainsObj = new Trains();
        trains = trainsObj.getArray();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1></br>");

        // Form to register
        out.println("<form method=\"post\" action=\"hello-servlet\">\n" +
                "<input type=\"text\" name=\"ID\" placeholder=\"Train ID\" pattern=\"^[{]?[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}[}]?$\"/>\n" +
                "<input type=\"text\" name=\"Name\" placeholder=\"Reservation name\"/>\n" +
                "<input type=\"submit\" />\n" +
                "</form>");

        // List of all trains
        for(Train train : trains) {
            out.println(train);
        }
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String idProvided = request.getParameter("ID");
        String nameProvided = request.getParameter("Name");

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        // Depending on the tickets left, gives a different result
        switch(trainsObj.sellTicket(idProvided)) {
            case "OK":
                trains = trainsObj.getArray();
                pw.println("<h2>");
                pw.println("Thank you " + nameProvided + " for your order!!");
                pw.println("</h2><h3>");
                pw.println("Train details:</h3></br>");
                pw.println(trainsObj.getTrain(idProvided));
                break;
            case "NOTICKET":
                pw.println("<h2>");
                pw.println("Sorry " + nameProvided);
                pw.println("!</h2><h3>No tickets left</h3>");
                break;
            case "NOTRAIN":
                pw.println("<h2>");
                pw.println("Sorry " + nameProvided);
                pw.println("!</h2><h3>Train hasn't been found</h3>");
                break;
            default:
                pw.println("<h2>Error</h2>");
                break;
        }

        pw.println("</br><a href=\"hello-servlet\">Go back</a>");
    }

    public void destroy() {
    }
}