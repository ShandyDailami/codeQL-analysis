import java.sql.*;

public class java_27640_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Establish a connection to the database
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "username";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database");

            // Create a statement
            Statement stmt = conn.createStatement();

            // Perform a query
            String sql = "SELECT * FROM Users WHERE username = 'user1' AND password = 'pass1'";
            ResultSet rs = stmt.executeQuery(sql);

            // Process the result set
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
        }
    }
}