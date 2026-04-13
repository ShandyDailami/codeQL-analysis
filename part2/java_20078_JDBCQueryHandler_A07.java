import java.sql.*;

public class java_20078_JDBCQueryHandler_A07 {
    // Database credentials
    private String url = "jdbc:mysql://localhost:3306/mydatabase";
    private String username = "root";
    private String password = "password";

    // Connection and Statement
    private Connection conn = null;
    private Statement stmt = null;

    // ResultSet
    private ResultSet rs = null;

    // Query
    private String query = "SELECT * FROM users WHERE username = ?";

    public java_20078_JDBCQueryHandler_A07() {
        try {
            // Step 1: Establish the Connection
            conn = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare the Statement
            stmt = conn.prepareStatement(query);

            // Set the parameter value
            stmt.setString(1, "testUser");

            // Step 3: Execute the Statement
            rs = stmt.executeQuery();

            // Process the ResultSet
            while (rs.next()) {
                System.out.println("User: " + rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 4: Close the Connection
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