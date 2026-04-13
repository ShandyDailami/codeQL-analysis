import java.sql.*;

public class java_05136_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // Set up the database connection
        String url = "jdbc:mysql://localhost:3306/mydb"; // replace with your actual database url
        String username = "username"; // replace with your actual username
        String password = "password"; // replace with your actual password

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database!");

            // Example of a query that might be a security-sensitive operation
            String selectQuery = "SELECT * FROM users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(selectQuery);
            pstmt.setString(1, "admin"); // admin is a security-sensitive operation, replace with actual user

            ResultSet rs = pstmt.executeQuery();

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