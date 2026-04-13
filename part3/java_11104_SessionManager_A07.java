import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_11104_SessionManager_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Prepare a statement
            stmt = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");

            // Set parameters and execute the statement
            stmt.setString(1, "username");
            stmt.setString(2, "password");
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Successfully authenticated!");
            } else {
                System.out.println("Authentication failed!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            // Close the resources
            if (stmt != null) try { stmt.close(); } catch(SQLException e) {}
            if (conn != null) try { conn.close(); } catch(SQLException e) {}
        }
    }
}