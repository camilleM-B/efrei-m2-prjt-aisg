package restserver.restserver;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class Price extends ServerResource {
    @Get
    public String toString() {
        String price = (String) getRequestAttributes().get("price");
        long lprice = Long.parseLong(price);

        List<List> idprice = null;
        try {
            idprice = filterTrain(lprice);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<String> filtertrain = idprice.get(0);
        List<Integer> filterprice = idprice.get(1);

        //List <String> filterprice = filtertrain.stream().map(Train::getId).collect(Collectors.toList());

        String trainanswer = filtertrain.toString();
        String priceanswer = filterprice.toString();

        if (filtertrain != null && filtertrain.isEmpty()) {
            return "No available train";
        }

        return "The items at " + lprice + "  to  bought are Train of IDs: " + trainanswer + "  of corresponding fares: " + priceanswer;

    }


    public List<List> filterTrain(long price) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tp_aisg_efrei", "postgres", "camille");
        Statement stmt = conn.createStatement();
        ResultSet res = stmt.executeQuery("SELECT * FROM trains WHERE price=" + price);

        List<String> idlist = new ArrayList<>();
        List<Integer> priceList = new ArrayList<>();


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