import java.sql.*;

public class java_13982_JDBCQueryHandler_A01 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a Connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Execute a Statement
            stmt = conn.createStatement();

            // Step 4: Execute a Query
            rs = stmt.executeQuery("SELECT * FROM Users WHERE role='admin'");

            // Step 5: Process the ResultSet
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String role = rs.getString("role");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
                System.out.println("Role: " + role);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
       
        } finally {
            // Step 6: Clean up
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
        }
    }
}