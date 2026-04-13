import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_26122_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Database URL
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        // Database username
        String username = "myusername";
        // Database password
        String password = "mypassword";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM mytable");

            while (rs.next()) {
                System.out.println("Row 1: " + rs.getString("mycolumn"));
            }

            rs.close();
        } catch (SQLException e) {
            System.out.println("Error in JDBC connection or query execution: " + e.getMessage());
        }
    }
}