import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_36997_SessionManager_A08 {
    // URL and username for database connection
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to the database");

            // Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT USERNAME FROM USERS WHERE USERNAME = 'USER1'";
            ResultSet rs = stmt.executeQuery(sql);

            // Process the ResultSet
            while (rs.next()) {
                String userName = rs.getString("USERNAME");
                System.out.println("User: " + userName);
            }

            // Closing the statement and connection
            stmt.close();
            conn.close();
            System.out.println("Finished");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e3) {
                e3.printStackTrace();
            }
        }
    }
}