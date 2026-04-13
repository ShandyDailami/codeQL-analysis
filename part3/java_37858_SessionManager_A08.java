import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_37858_SessionManager_A08 {

    private static SessionFactory sessionFactory;

    // Method to create session factory
    public static SessionFactory createSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }

    // Method to open a session
    public static Session openSession() {
        if (sessionFactory == null) {
            sessionFactory = createSessionFactory();
        }
        return sessionFactory.openSession();
    }

    // Method to close a session
    public static void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    // Method to perform security sensitive operation
    public static void performSecuritySensitiveOperation(Session session) {
        // Here's where we perform a security sensitive operation
        // e.g. we insert a new user into the database
        session.beginTransaction();
        session.save(new User("username", "password"));
        session.getTransaction().commit();
    }

    public static void main(String[] args) {
        Session session = openSession();
        try {
            performSecuritySensitiveOperation(session);
        } finally {
            closeSession(session);
        }
    }
}

class User {
    private String username;
    private String password;

    public java_37858_SessionManager_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }
    // getters and setters
}