import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_29059_JDBCQueryHandler_A03 {
    // URL and credentials for the database
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 1. Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish the connection
            conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

            // 3. Create the SQL query
            String sql = "SELECT password FROM users WHERE username = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "testUser"); // Test user

            // 4. Execute the query and process the result
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String password = rs.getString("password");
                System.out.println("Password: " + password);
            } else {
                System.out.println("No user found with the given username");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found");
        } catch (SQLException e) {
            System.out.println("Error in accessing the database");
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error in closing connection");
            }
        }
    }
}