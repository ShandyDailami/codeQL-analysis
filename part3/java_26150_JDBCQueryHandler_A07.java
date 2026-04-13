import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_26150_JDBCQueryHandler_A07 {

    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    // Database credentials
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName(DB_DRIVER);

            // Step 2: Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Create a statement
            pstmt = conn.prepareStatement("SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?");

            // Setting the parameters
            pstmt.setString(1, "validUser");
            pstmt.setString(2, "validPassword");

            // Step 4: Execute the query
            rs = pstmt.executeQuery();

            // Step 5: Process the result
            if (rs.next()) {
                System.out.println("Valid user");
            } else {
                System.out.println("Invalid user or password");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}