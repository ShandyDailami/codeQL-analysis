import java.sql.*;

public class java_15118_JDBCQueryHandler_A01 {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1. Open a connection
            conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            // 2. Create a statement
            stmt = conn.createStatement();

            // 3. Execute a query
            rs = stmt.executeQuery("SELECT * FROM users WHERE role='ADMIN'");

            // 4. Process the result set
            while (rs.next()) {
                System.out.println(rs.getString("username") + " is an " + rs.getString("role"));
            }
        } catch (SQLException e) {
            System.out.println("Error in connection or query execution: " + e.getMessage());
         } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error in closing connections: " + e.getMessage());
            }
        }
    }
}