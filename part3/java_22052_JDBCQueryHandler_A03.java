import java.sql.*;

public class java_22052_JDBCQueryHandler_A03 {
    // Database credentials
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    // JDBC driver name and database URL
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/test";

    public static void main(String[] args) {
        // Step 1: Register JDBC driver
        try {
            Class.forName(DRIVER);
        } // end try
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // Step 2: Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            // Step 3: Execute a query
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "user1");

            ResultSet rs = pstmt.executeQuery();

            // Step 4: Handle the ResultSet
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("User: " + username + " Password: " + password);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}