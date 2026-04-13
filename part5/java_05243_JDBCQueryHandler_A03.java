import java.sql.*;

public class java_05243_JDBCQueryHandler_A03 {
    // Assuming we have a database called 'test' with a table called 'users'
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // 1. Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // 2. Create a statement
            stmt = conn.createStatement();

            // 3. Execute a SQL query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE email = '" + args[0] + "'");

            // 4. Process the result
            while (rs.next()) {
                System.out.println("User found: " + rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5. Close the resources
            try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
            try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }
    }
}