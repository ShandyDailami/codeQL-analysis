import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_32498_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        // Driver load
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        }

        // Connection and Statement creation
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");
             Statement stmt = conn.createStatement()) {

            // Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users");

            // Process ResultSet
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Error in accessing database.");
            e.printStackTrace();
        }
    }
}