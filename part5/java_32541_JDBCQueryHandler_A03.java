import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_32541_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish Connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Prepare SQL Query
            String sql = "SELECT * FROM users WHERE username = ?";
            pstmt = conn.prepareStatement(sql);

            // Step 4: Set parameter values
            pstmt.setString(1, "admin");

            // Step 5: Execute Query
            pstmt.execute();

            // Step 6: Handle Result
            // ...
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 7: Close Resource
            if (pstmt != null) try { pstmt.close(); } catch(SQLException e){ /* can't do anything */ }
            if (conn != null) try { conn.close(); } catch(SQLException e){ /* can't do anything */ }
        }
    }
}