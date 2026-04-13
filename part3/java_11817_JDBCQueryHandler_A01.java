import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_11817_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // Connect to the database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb", "username", "password");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database.");
            e.printStackTrace();
            return;
        }

        // Use the connection object to perform database operations
        String sql = "SELECT * FROM Users WHERE username = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "user1");
            ResultSet rs = stmt.executeQuery();

            // Process the ResultSet
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query.");
            e.printStackTrace();
        }

        // Close the connection
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error closing the connection.");
                e.printStackTrace();
            }
        }
    }
}