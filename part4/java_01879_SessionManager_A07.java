import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_01879_SessionManager_A07 {

    private static SessionFactory sessionFactory;

    private java_01879_SessionManager_A07() {
        // Prevent instantiation
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.configure("hibernate.cfg.xml"); // Load configuration from hibernate.cfg.xml
                sessionFactory = configuration.buildSessionFactory();
            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }

    public Session openSession() {
        return getSessionFactory().openSession();
    }

    public static void main(String[] args) {
        Session session = getSessionFactory().openSession();
        try {
            session.beginTransaction();
            // Perform operations here
            session.getTransaction().commit();
            session.close();
        } finally {
            session.close();
        }
    }
}