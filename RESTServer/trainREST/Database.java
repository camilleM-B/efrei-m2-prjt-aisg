package trainREST;

import java.sql.*;

public class Database {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tp_aisg_efrei";
        String username = "root";
        String password = "timothe123";

        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("connected to databse");

            String sql =  "SELECT * FROM trains";
            Statement stat = connection.createStatement();
            ResultSet result = stat.executeQuery(sql);

            while (result.next()){
                String id = result.getString("id");
                System.out.println(id);

            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("can't connect to databse");
            e.printStackTrace();
        }
    }
}
