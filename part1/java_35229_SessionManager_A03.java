public class java_35229_SessionManager_A03 {
    // Using a static Session instance to make sure a single session is created
    private static Session session;

    // Private constructor to prevent instantiation
    private java_35229_SessionManager_A03() { }

    // Method to get the Session
    public static Session getSession() {
        if (session == null) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }

    // Method to close the Session
    public static void closeSession() {
        session.close();
        session = null;
    }
}

// Using HibernateUtil for session management
public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

// Using Hibernate for database operations
public class User {
    private String username;
    private String password;

    // getters and setters
}

public class Main {
    public static void main(String[] args) {
        // Creating a new Session
        Session session = SessionManager.getSession();

        try {
            // Begin a new transaction
            session.beginTransaction();

            // Inserting a new user
            User user = new User();
            user.setUsername("test");
            user.setPassword("password");
            session.save(user);

            // Commit the transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            // Closing the session
            SessionManager.closeSession();
        }
    }
}