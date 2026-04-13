import java.sql.*;

public class java_27408_JDBCQueryHandler_A03 {
    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Load MySQL driver
            Class.forName(DB_DRIVER);

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Prepare a statement
            stmt = conn.createStatement();

            // Execute SQL query
            String sql = "SELECT password FROM users WHERE username = 'username'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String password = rs.getString("password");
                System.out.println("Password: " + password);
           
                // Security-sensitive operation, e.g., hashing the password
                // ...
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the statement and connection
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException e) { /* ignore */ }
            }
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) { /* ignore */ }
            }
        }
    }
}