import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Session;
import java.sql.SQLException;

public class java_15265_SessionManager_A01 {
    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Session session = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName(DB_DRIVER);

            // Step 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Create a session
            session = conn.createSession();

            // Step 4: Use the session
            // In this example, we're just closing the session, but you could do anything with it
            session.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Ensure connections are closed
            if (session != null) {
                session.close();
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}