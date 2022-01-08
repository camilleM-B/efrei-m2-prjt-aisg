package soapserver.soapserver;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private Trains trainsObj;
    private Train[] trains;

    public void init() {
        message = "rent a boyfriend!";
        trainsObj = new Trains();
        trains = trainsObj.getArray();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1></br>");
        for(Train train : trains) {
            out.println(train);
        }
        out.println("</body></html>");
    }

    public void destroy() {
    }
}