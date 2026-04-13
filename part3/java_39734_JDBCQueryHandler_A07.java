import java.sql.*;

public class java_39734_JDBCQueryHandler_A07 {

    // Database credentials
    private static final String DB_USERNAME = "your_username";
    private static final String DB_PASSWORD = "your_password";

    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";

    public java_39734_JDBCQueryHandler_A07() {
        // Initialize connection and statement
        Connection conn = null;
        Statement stmt = null;

        try {
            // Load the driver
            Class.forName(DB_DRIVER);

            // Open connection
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM your_table";
            ResultSet rs = stmt.executeQuery(sql);

            // Process result set
            while (rs.next()) {
                // Process a row
                String username = rs.getString("username");
                String password = rs.getString("password");

                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Clean up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            // Handle any errors
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new JDBCQueryHandler();
    }
}