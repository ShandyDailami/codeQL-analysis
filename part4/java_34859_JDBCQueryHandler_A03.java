import java.sql.*;

public class java_34859_JDBCQueryHandler_A03 {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1. Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 2. Create a statement
            stmt = conn.createStatement();

            // 3. Execute a query
            rs = stmt.executeQuery("SELECT password FROM users WHERE username = 'myuser'");

            // 4. Retrieve password from ResultSet
            if (rs.next()) {
                String password = rs.getString("password");
                System.out.println("Password: " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5. Clean up resources
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