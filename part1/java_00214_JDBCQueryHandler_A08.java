import java.sql.*;

public class java_00214_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn.setAutoCommit(false); // disable auto commit to simulate transaction

            // Step 2: Create a statement
            stmt = conn.createStatement();

            // Step 3: Execute a query and process the result set
            rs = stmt.executeQuery("SELECT * FROM Users WHERE username = 'user1'");
            while (rs.next()) {
                String password = rs.getString("password");
                // Here you can perform security-sensitive operations like checking if the password matches a hash
                // This is a hypothetical example and does not reflect a real-world security situation
            }

            // Step 4: Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Ensure all resources are closed
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}