import java.sql.*;

public class java_01060_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Establish a connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Create a statement
            stmt = conn.createStatement();

            // Step 3: Execute a query
            rs = stmt.executeQuery("SELECT * FROM Users WHERE username='" + args[0] + "' AND password='" + args[1] + "'");

            // Step 4: Process the results
            while (rs.next()) {
                System.out.println("User found: " + rs.getString("username"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Cleanup
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