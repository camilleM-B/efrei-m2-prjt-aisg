package restserver.restserver;

import org.json.simple.JSONArray;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class Ticket extends ServerResource {
    @Get
    @Produces({MediaType.APPLICATION_JSON})

    public String returnJSONData() throws SQLException, ClassNotFoundException {
        String Stickets = (String) getRequestAttributes().get("nbrtickets");
        int Itickets = Integer.parseInt(Stickets);

        List<List> idprice = filterTrain(Itickets);
        List<String> filtertrain = idprice.get(0);
        List<Integer> filterprice = idprice.get(1);


        JSONArray jsonarray = new JSONArray();
        for (int i = 0; i < filtertrain.size(); i++) {
            JSONObject temp = new JSONObject();
            temp.put("id", filtertrain.get(i));
            //temp.put("price", filterprice.get(i));
            System.out.println(i);


            jsonarray.add(temp);
        }

        if (filtertrain != null && filtertrain.isEmpty()) {
            return "No available train";
        }

        System.out.println(jsonarray);
        return jsonarray.toString();
    }


    public List<List> filterTrain(int tickets) throws ClassNotFoundException, SQLException {

        List<String> idlist = new ArrayList<>();
        List<Integer> priceList = new ArrayList<>();

        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tp_aisg_efrei", "postgres", "camille");
        Statement stmt = conn.createStatement();
        ResultSet res = stmt.executeQuery("SELECT * FROM trains WHERE totalTickets =" + tickets);

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
