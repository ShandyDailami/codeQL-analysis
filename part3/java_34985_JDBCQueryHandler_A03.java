import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_34985_JDBCQueryHandler_A03 {
    // JDBC driver name and database URL
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/mydatabase";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 1. Register JDBC driver
            Class.forName(DRIVER);

            // 2. Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 3. Execute a query
            pstmt = conn.prepareStatement("SELECT * FROM MY_TABLE");
            rs = pstmt.executeQuery();

            // 4. Retrieve the result
            while (rs.next()) {
                System.out.println(rs.getString("NAME"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 5. Close resources
            if (rs != null) try { rs.close(); } catch (SQLException e) {}
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
            if (conn != null) try { conn.close(); } catch (SQLException e) {}
        }
    }
}