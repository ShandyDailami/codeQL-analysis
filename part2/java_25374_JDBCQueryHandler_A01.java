import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_25374_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // Connect to the database
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";
        
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {
            
            // Execute a SQL query
            String sql = "SELECT * FROM users WHERE username = 'admin' AND password = 'password'";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("User: " + username + ", Password: " + password);
            }
        } catch (SQLException e) {
            System.out.println("Error in connection or query execution: " + e.getMessage());
        }
    }
}