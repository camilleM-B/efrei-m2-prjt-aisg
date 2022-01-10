package restserver.restserver;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Station extends ServerResource {
    @Get
    public String toString() {
        String dstation = (String) getRequestAttributes().get("dstation");
        String astation = (String) getRequestAttributes().get("astation");


        List<List> idprice = null;
        try {
            idprice = filterTrain(dstation, astation);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<String> filtertrain = idprice.get(0);
        List<Integer> filterprice = idprice.get(1);

        String trainanswer = filtertrain.toString();
        String priceanswer = filterprice.toString();

        if (filtertrain != null && filtertrain.isEmpty()) {
            return "No available train";
        }

        return "The train departing from " + astation + " to " + dstation +
                " are: " + trainanswer + "  of corresponding fares: " + priceanswer;
    }

    private List<List> filterTrain(String dstation, String astation) throws ClassNotFoundException, SQLException {

        List<String> idlist = new ArrayList<>();
        List<Integer> priceList = new ArrayList<>();

        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tp_aisg_efrei", "postgres", "camille");
        Statement stmt = conn.createStatement();
        ResultSet res = stmt.executeQuery("SELECT * FROM trains WHERE departureStation = '" + dstation.trim() + "' AND arrivalStation = '" + astation.trim() + "'");


        while (res.next()) {
            String id = res.getString("id");
            int priceT = res.getInt("price");
            priceList.add(priceT);
            idlist.add(id);
        }

        conn.close();

        List<List> map = new ArrayList<List>();
        map.add(idlist);
        map.add(priceList);
        return map;
    }
}  
