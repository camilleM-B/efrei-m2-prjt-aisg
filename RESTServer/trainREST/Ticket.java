package trainREST;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Ticket extends ServerResource {
    @Get
    public String toString() {
        String Stickets = (String) getRequestAttributes().get("nbrtickets");
        int Itickets = Integer.parseInt(Stickets);

        List <List>  idprice = filterTrain(Itickets);
        List<String> filtertrain = idprice.get(0);
        List<Integer> filterprice = idprice.get(1);

        String trainanswer =  filtertrain.toString();
        String priceanswer = filterprice.toString();

        if (filtertrain != null && filtertrain.isEmpty()) { return "No available train"; }

        return "The trains with a total of " + Itickets + " tickets are the trains of IDs: " + trainanswer + "  of corresponding fares: " + priceanswer;

    }

    public List <List> filterTrain(int tickets) {

        List<String> idlist= new ArrayList<>();
        List<Integer> priceList = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/tp_aisg_efrei";
        String username = "root";
        String password = "timothe123";

        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            String sql =  "SELECT * FROM trains WHERE totalTickets ="+ tickets;
            Statement stat = connection.createStatement();
            ResultSet result = stat.executeQuery(sql);

            while (result.next()){
                String id = result.getString("id");
                int priceT = result.getInt("price");
                priceList.add(priceT);
                idlist.add(id);
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("can't connect to databse");
            e.printStackTrace();
        }

        List< List> map =new ArrayList<List>();
        map.add(idlist);
        map.add(priceList);
        return map;
    }

}
