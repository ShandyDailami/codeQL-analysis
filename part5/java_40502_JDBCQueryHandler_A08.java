import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_40502_JDBCQueryHandler_A08 {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Prepare the statement
            String sql = "SELECT password FROM Users WHERE username = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "testUser"); // Replace with the user you want to query

            // Step 4: Execute the statement
            rs = pstmt.executeQuery();

            // Step 5: Handle the result
            if (rs.next()) {
                String password = rs.getString("password");
                System.out.println("Password: " + password);
            } else {
                System.out.println("No user found.");
            }

            // Step 6: Clean up
            if (pstmt != null) { pstmt.close(); }
            if (conn != null) { conn.close(); }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}