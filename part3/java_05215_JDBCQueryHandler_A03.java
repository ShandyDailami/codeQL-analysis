import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_05215_JDBCQueryHandler_A03 {

    // JDBC driver name and database URL
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // Step 1: Register JDBC driver
            Class.forName(DRIVER);

            // Step 2: Open a connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Execute a query
            pstmt = conn.prepareStatement("SELECT * FROM MY_TABLE");
            rs = pstmt.executeQuery();

            // Step 4: Retrieve data from result set
            while (rs.next()) {
                System.out.println("Found user in the database");
                System.out.println("User ID: " + rs.getString("id"));
                System.out.println("User Name: " + rs.getString("name"));
                System.out.println("User Email: " + rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close resources
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}