public class java_22250_SessionManager_A01 {
    private static SessionManager instance;
    private SessionFactory sessionFactory;

    // Private constructor to restrict instantiation of the class
    private java_22250_SessionManager_A01() {
        // Create session factory using C3P0 Connection Pool and Hibernate Validator
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    public void beginTransaction(Session session) {
        if (session != null) {
            session.beginTransaction();
        }
    }

    public void commitTransaction(Session session) {
        if (session != null) {
            session.getTransaction().commit();
        }
    }

    public void rollbackTransaction(Session session) {
        if (session != null) {
            session.getTransaction().rollback();
        }
    }
}