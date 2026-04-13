import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_29902_SessionManager_A03 {

    // Driver for MySQL database
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

    // Database URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        SessionFactory sessionFactory = null;
        try {
            // Load MySQL Driver
            Class.forName(DB_DRIVER);

            // Establish the connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Create SessionFactory
            sessionFactory = conn.setAutoCommit(false);

            // Create session
            Session session = sessionFactory.openSession();

            // Start the transaction
            session.beginTransaction();

            // Perform operations on the session here
            // ...

            // Commit the transaction
            session.getTransaction().commit();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
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