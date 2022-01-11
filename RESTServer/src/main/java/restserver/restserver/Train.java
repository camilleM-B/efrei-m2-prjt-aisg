package restserver.restserver;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Train extends ServerResource {
    @Get
    @Produces({MediaType.APPLICATION_JSON})
    public String returnJSONData() throws SQLException, ClassNotFoundException {
        List<List> idprice = filterTrain();

        List<String> filtertrain = idprice.get(0);
        List<String> filterdepartS = idprice.get(1);
        List<String> filterarrivalS = idprice.get(2);

        List<Date> filterdepartD = idprice.get(3);
        List<Date> filterarrivalD = idprice.get(4);

        List<Integer> filtertotalT = idprice.get(5);
        List<Integer> filterremainT = idprice.get(6);

        List<String> filterclass = idprice.get(7);

        List<Integer> filterprice = idprice.get(8);

        JSONArray jsonarray = new JSONArray();
        for (int i = 0; i < filtertrain.size(); i++) {
            JSONObject temp = new JSONObject();
            temp.put("id", filtertrain.get(i));
            temp.put("departureStation", filterdepartS.get(i));
            temp.put("arrivalStation", filterarrivalS.get(i));

            temp.put("outboundDate", filterdepartD.get(i).toString());
            temp.put("returnDate", filterarrivalD.get(i).toString());

            temp.put("totalTickets", filtertotalT.get(i));
            temp.put("remainingTickets", filterremainT.get(i));

            temp.put("travelClass", filterclass.get(i));

            temp.put("price", filterprice.get(i));

            jsonarray.add(temp);
        }

        if (filtertrain != null && filtertrain.isEmpty()) {
            return "No available train";
        }

        return jsonarray.toString();
    }

    public List<List> filterTrain() throws ClassNotFoundException, SQLException {

        List<String> idlist = new ArrayList<>();
        List<String> aslist = new ArrayList<>();
        List<String> dslist = new ArrayList<>();
        List<String> tclist = new ArrayList<>();

        List<Date> oList = new ArrayList<>();
        List<Date> aList = new ArrayList<>();

        List<Integer> priceList = new ArrayList<>();
        List<Integer> ttList = new ArrayList<>();
        List<Integer> rtList = new ArrayList<>();

        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tp_aisg_efrei", "postgres", "camille");
        Statement stmt = conn.createStatement();
        ResultSet res = stmt.executeQuery("SELECT * FROM trains ORDER BY outboundDate");


        while (res.next()) {
            String id = res.getString("id");
            String dStation = res.getString("departureStation");
            String aStation = res.getString("arrivalStation");
            Date oDate = res.getDate("outboundDate");
            Date aDate = res.getDate("returnDate");
            int Ttickets = res.getInt("totalTickets");
            int Rtickets = res.getInt("remainingTickets");
            String Tclass = res.getString("travelClass");
            int priceT = res.getInt("price");

            idlist.add(id);
            aslist.add(dStation);
            dslist.add(aStation);
            tclist.add(Tclass);

            oList.add(oDate);
            aList.add(aDate);

            ttList.add(Ttickets);
            rtList.add(Rtickets);

            priceList.add(priceT);
        }

        conn.close();

        List<List> map = new ArrayList<List>();
        map.add(idlist);
        map.add(dslist);
        map.add(aslist);
        map.add(oList);
        map.add(aList);
        map.add(ttList);
        map.add(rtList);
        map.add(tclist);
        map.add(priceList);
        return map;
    }
}
