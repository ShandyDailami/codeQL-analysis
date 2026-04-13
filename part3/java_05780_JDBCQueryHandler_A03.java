import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_05780_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        // Hard-coded database connection parameters
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        // Hard-coded SQL query
        String query = "SELECT * FROM Users WHERE username = 'username' AND password = 'password'";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                // Do something with the result set
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}