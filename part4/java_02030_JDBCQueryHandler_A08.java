import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_02030_JDBCQueryHandler_A08 {

    // URL to access the database
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";

    // Username and password to access the database
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1. Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish the connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // 3. Create a statement
            stmt = conn.createStatement();

            // 4. Execute the query
            String sql = "SELECT * FROM users WHERE role = 'admin'";
            rs = stmt.executeQuery(sql);

            // 5. Process the ResultSet
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error in connection or SQL execution: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error in closing connection: " + e.getMessage());
            }
        }
    }
}