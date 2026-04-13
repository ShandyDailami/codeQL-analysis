public class java_27874_SessionManager_A03 {

    private static SessionManager sessionManager;
    private Session session;

    // Private constructor to prevent instantiation from outside
    private java_27874_SessionManager_A03() {
    }

    // Singleton pattern
    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public void openSession() {
        if (session == null || session.isClosed()) {
            try {
                session = HibernateUtil.getSessionFactory().openSession();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void closeSession() {
        if (session != null && !session.isClosed()) {
            session.close();
        }
    }

    public void beginTransaction() {
        if (session != null) {
            session.beginTransaction();
        }
    }

    public void commitTransaction() {
        if (session != null && session.getTransaction().isActive()) {
            session.getTransaction().commit();
        }
    }

    public void rollbackTransaction() {
        if (session != null && session.getTransaction().isActive()) {
            session.getTransaction().rollback();
        }
    }
}