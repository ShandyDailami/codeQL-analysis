import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_22858_SessionManager_A08 {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    // The session factory
    private static org.hibernate.SessionFactory sessionFactory;

    // Create the session factory with the connection
    public static void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // The session factory
            sessionFactory = org.hibernate.cfg.Configuration.buildSessionFactory(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get the session
    public static org.hibernate.Session getSession() {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        // Initialize the session factory
        init();

        // Get the session
        org.hibernate.Session session = getSession();

        // Begin a transaction
        session.beginTransaction();

        // Do some integrity failure-related operations here...

        // Commit the transaction
        session.getTransaction().commit();

        // Close the session
        session.close();
    }
}