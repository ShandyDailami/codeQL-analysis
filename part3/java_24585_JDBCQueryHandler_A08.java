import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_24585_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Prepare statement
            stmt = conn.prepareStatement("SELECT * FROM mytable WHERE condition = ?");
            stmt.setString(1, "somevalue");

            // Step 4: Execute query and get result set
            rs = stmt.executeQuery();

            // Step 5: Process result set
            while (rs.next()) {
                String column1 = rs.getString("column1");
                String column2 = rs.getString("column2");
                // ... process result set
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close resources
            try { if (rs != null) rs.close(); } catch (SQLException e) { /* can't do anything */ }
            try { if (stmt != null) stmt.close(); } catch (SQLException e) { /* can't do anything */ }
            try { if (conn != null) conn.close(); } catch (SQLException e) { /* can't do anything */ }
        }
    }
}