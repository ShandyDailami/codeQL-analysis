import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Session;
import java.sql.SessionFactory;
import java.sql.SQLException;

public class java_19442_SessionManager_A03 {
    // JDBC driver name and database URL
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Session session = null;
        SessionFactory sf = null;

        try {
            // Step 1: Load the MySQL driver
            Class.forName(driver);

            // Step 2: Establish a connection to the database
            conn = DriverManager.getConnection(url, username, password);

            // Step 3: Create a SessionFactory
            sf = conn.getSessionFactory();

            // Step 4: Open a Session
            session = sf.openSession();

            // Step 5: Use the session
            // Your code here...

            session.close();
            conn.close();
            sf.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Ensure that the resources are closed properly
            try {
                if (session != null) {
                    session.close();
                }
                if (conn != null) {
                    conn.close();
                }
                if (sf != null) {
                    sf.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}