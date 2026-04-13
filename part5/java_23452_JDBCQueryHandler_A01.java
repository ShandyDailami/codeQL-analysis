import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_23452_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL server
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb", "username", "password");

            // Create a statement
            Statement stmt = conn.createStatement();

            // Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE role='admin'");

            // Handle the ResultSet
            while (rs.next()) {
                String username = rs.getString("username");
                String role = rs.getString("role");
                System.out.println("Username: " + username);
                System.out.println("Role: " + role);
            }

            // Close the ResultSet, Statement, and Connection
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}