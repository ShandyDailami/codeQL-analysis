import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_21347_JDBCQueryHandler_A08 {
    // URL of the database
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";

    // User name and password for the database
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        // Establish a connection
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Register MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Prepare a statement
            pstmt = conn.prepareStatement("INSERT INTO USERS (USERNAME, PASSWORD) VALUES (?, ?)");

            // Set parameters and execute the statement
            pstmt.setString(1, "testUser");
            pstmt.setString(2, "testPassword");
            pstmt.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}