package trainREST;


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
            Connection connection = DriverManager.getConnection(url,username,password);

            //get actual remainingtickets
            
            String sql =  "SELECT * FROM trains WHERE id ='"+ id.trim()+"'";
            Statement stat = connection.createStatement();
            ResultSet result = stat.executeQuery(sql);

            int remaining = 0;

            while (result.next()) {
                remaining = result.getInt("remainingTickets");
            }

            if (remaining == 0){return false;}

            //if tickets available update

            String sql2 =  "UPDATE trains SET remainingTickets =remainingTickets-1 WHERE id ='"+ id.trim()+"' AND remainingTickets > 0";
            stat.executeUpdate(sql2);
            connection.close();

        } catch (SQLException e) {
            System.out.println("can't connect to databse");
            //  e.printStackTrace();
            return false;
        }

         return true;

    }
}
