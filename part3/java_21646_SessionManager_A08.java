public class java_21646_SessionManager_A08 {
    private static SessionManager sessionManager;

    private java_21646_SessionManager_A08() {
        // Private constructor to prevent instantiation
    }

    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    private Session currentSession;

    public void openSession() {
        // Open a new session. Here, we assume the session is open if it's not null.
        // In a real application, you should handle this properly with appropriate exception handling.
        if (currentSession != null) {
            throw new RuntimeException("Session is already open");
        }

        // Here we are just opening a session, in a real application you would likely have a more complex method to actually open the session
        // e.g. using a pool, setting properties, opening a connection etc.
        currentSession = Session.getCurrentSession();
        if (currentSession == null) {
            currentSession = HibernateUtil.openSession();
        }
    }

    public void closeSession() {
        // Close the current session and set it to null.
        // In a real application, you should handle this properly with appropriate exception handling.
        if (currentSession == null) {
            throw new RuntimeException("Session is not open");
        }

        currentSession.close();
        currentSession = null;
    }

    public Session getCurrentSession() {
        return currentSession;
    }
}

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private java_21646_SessionManager_A08() {
        // Private constructor to prevent instantiation
    }

    public static Session openSession() {
        // Open a new session. Here, we assume the session is open if it's not null.
        // In a real application, you should handle this properly with appropriate exception handling.
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            } catch (Throwable ex) {
                ex.printStackTrace();
                throw new ExceptionInInitializerError("Failed to initialize SessionFactory");
            }
        }

        return sessionFactory.openSession();
    }
}