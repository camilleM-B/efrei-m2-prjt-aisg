package restserver.restserver;

import java.sql.*;

public class Database {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tp_aisg_efrei", "postgres", "camille");
        Statement stmt = conn.createStatement();
        ResultSet res = stmt.executeQuery("SELECT * FROM trains");


        while (res.next()) {
            String id = res.getString("id");
            System.out.println(id);

        }

        conn.close();

    }
}
