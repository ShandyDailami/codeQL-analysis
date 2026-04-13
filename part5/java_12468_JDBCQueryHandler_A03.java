import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_12468_JDBCQueryHandler_A03 {

    // JDBC driver name and database URL
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";

    // Database credentials
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName(driver);

            // Step 2: Establish a connection
            conn = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare statement
            pstmt = conn.prepareStatement("INSERT INTO EMPLOYEE (ID, NAME, AGE) VALUES (?, ?, ?)");

            // Step 4: Execute statement
            pstmt.setInt(1, 20);
            pstmt.setString(2, "John");
            pstmt.setInt(3, 30);
            pstmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close connection, statement, and resultset
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}