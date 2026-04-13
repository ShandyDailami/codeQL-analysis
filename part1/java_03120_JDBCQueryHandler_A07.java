import java.sql.*;

public class java_03120_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish Connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 3: Create Statement
            stmt = conn.createStatement();

            // Step 4: Execute SQL Query
            String sql = "SELECT * FROM Users WHERE username = '" + args[0] + "' and password = '" + args[1] + "'";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 5: Process the Result
            while (rs.next()) {
                System.out.println("Found user: " + rs.getString("username"));
            }

            // Step 6: Close the ResultSet, Statement, and Connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        } finally {
            // Step 7: Cleanup
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}