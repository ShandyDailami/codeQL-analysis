import java.sql.*;

public class java_31250_JDBCQueryHandler_A07 {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Establish the database connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection established successfully.");

            // Step 2: Prepare the SQL statement
            String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            // Step 3: Execute the SQL statement
            preparedStmt.setString(1, "testUser");
            preparedStmt.setString(2, "testPassword");
            rs = preparedStmt.executeQuery();

            // Step 4: Process the results
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 5: Cleanup
            rs.close();
            preparedStmt.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            // Ensure resources are closed in all cases
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}