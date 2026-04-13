import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Session;
import java.sql.SessionFactory;

public class java_38009_SessionManager_A03 {
    // Connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    private static SessionFactory sessionFactory;

    private java_38009_SessionManager_A03() {
    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL driver class name
                Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

                // Create session factory
                sessionFactory = new org.hibernate.cfg.Configuration()
                        .configure("hibernate.cfg.xml") // config file
                        .addAnnotatedClass(Entity.class) // Entity class
                        .openSession();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static Session getSession() {
        return getSessionFactory().openSession();
    }

    public static void main(String[] args) {
        Session session = getSession();

        // Begin transaction
        session.beginTransaction();

        // Use session object to perform operations
        // ...

        // Commit transaction
        session.getTransaction().commit();

        session.close();
    }
}