package trainREST;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import java.sql.*;

public class Reservation {

    public static void main(String[] args) {
       boolean test = reservation("ed0830d6-71fc-11ec-981f-a81e84e24716");
       System.out.println(test);
    }

    public static boolean reservation(String id){


        String url = "jdbc:mysql://localhost:3306/tp_aisg_efrei";
        String username = "root";
        String password = "timothe123";

        try {
            System.out.println("connect to databse");
            Connection connection = DriverManager.getConnection(url,username,password);

            //get actual remainingtickets

            String sql =  "SELECT * FROM trains WHERE id ='"+ id.trim()+"'";

            Statement stat = connection.createStatement();
            ResultSet result = stat.executeQuery(sql);
            System.out.println("sql ="+sql);
            System.out.println("reuslt ="+result);

            int remaining = 0;

            while (result.next()) {

                remaining = result.getInt("remainingTickets");
            }

            int remain1 = Integer.valueOf(remaining) -1;


            System.out.println("sql th "+ "UPDATE trains SET remainingTickets ="+ remain1 +" WHERE id ='"+ id.trim()+"'");
            String sql2 =  "UPDATE trains SET remainingTickets ="+ remain1 +" WHERE id ='"+ id.trim()+"'";
            System.out.println("sql "+sql2);
            ResultSet result2 = stat.executeQuery(sql2);

            System.out.println("kill me baby one more time ");

            while (result2.next()) {
                System.out.println("aaaaaaaaaaaaaaaaaa ");
                remaining = result2.getInt("remainingTickets");
                System.out.println("remaining " + remaining);
            }
            System.out.println("success!");
            connection.close();

        } catch (SQLException e) {
            System.out.println("can't connect to databse");
            //  e.printStackTrace();
            return false;
        }

         return true;

    }
}
