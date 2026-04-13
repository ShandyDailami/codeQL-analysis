import java.sql.*;

public class java_35466_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // Establish a connection to the database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Assume MySQL connection
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydatabase", "username", "password");

            // Perform a security-sensitive operation
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "admin"); // Use admin's username
            ResultSet rs = pstmt.executeQuery();

            // Process the result set
            while (rs.next()) {
                String username = rs.getString("username");
                System.out.println("User: " + username);
            }

            // Close the connection
            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Failed to connect to database: " + e.getMessage());
        }
    }
}