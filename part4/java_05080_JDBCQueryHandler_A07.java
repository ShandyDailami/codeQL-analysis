import java.sql.*;
import java.util.Properties;

public class java_05080_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Set up the connection properties
            Properties props = new Properties();
            props.setProperty("user", "username");
            props.setProperty("password", "password");
            props.setProperty("database", "database");
            props.setProperty("url", "jdbc:mysql://localhost:3306/mydatabase");

            // Establish a connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");

            // Create a statement
            stmt = conn.createStatement();

            // Execute a query
            rs = stmt.executeQuery("SELECT * FROM users WHERE role='admin'");

            // Process the result set
            while (rs.next()) {
                String name = rs.getString("name");
                String role = rs.getString("role");
                System.out.println("Name: " + name);
                System.out.println("Role: " + role);
            }

            // Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}