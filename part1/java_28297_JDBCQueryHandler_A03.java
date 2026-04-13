import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_28297_JDBCQueryHandler_A03 {

    public static void main(String[] args) {

        // Establish a connection
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();

            // Security-sensitive operation
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE ID = '" + id + "'");

            while (rs.next()) {
                System.out.println(rs.getString("UserName"));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}