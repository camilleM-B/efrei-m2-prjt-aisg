package restserver.restserver;


import java.sql.*;

public class Reservation {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        boolean test = reservation("ed0830d6-71fc-11ec-981f-a81e84e24716");
        System.out.println(test);
    }

    public static boolean reservation(String id) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tp_aisg_efrei", "postgres", "camille");
        Statement stmt = conn.createStatement();
        ResultSet res = stmt.executeQuery("SELECT * FROM trains WHERE id ='" + id.trim() + "'");

        int remaining = 0;

        while (res.next()) {
            remaining = res.getInt("remainingTickets");
        }

        if (remaining == 0) {
            return false;
        }

        //if tickets available update

        String sql2 = "UPDATE trains SET remainingTickets =remainingTickets-1 WHERE id ='" + id.trim() + "' AND remainingTickets > 0";
        stmt.executeUpdate(sql2);
        conn.close();
        return true;
    }
}
