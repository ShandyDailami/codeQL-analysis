import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_27769_SessionManager_A08 {

    private static SessionFactory sessionFactory;

    private java_27769_SessionManager_A08() {
        // private constructor to prevent instantiation
    }

    static {
        try {
            // Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Could not load JDBC driver");
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.configure("hibernate.cfg.xml");

                sessionFactory = configuration.buildSessionFactory();
            } catch (Throwable ex) {
                ex.printStackTrace();
                throw new ExceptionInInitializerError("Initial SessionFactory creation failed.");
            }
        }
        return sessionFactory;
    }

    public static Session getSession() {
        return getSessionFactory().openSession();
    }

    public static void main(String[] args) throws SQLException {
        // Initialize the session factory
        SessionFactory sessionFactory = getSessionFactory();

        // Open a session
        Session session = sessionFactory.openSession();

        // Start a transaction
        session.beginTransaction();

        // Use the session object to perform operations
        // ...

        // Commit the transaction
        session.getTransaction().commit();
        session.close();
    }
}