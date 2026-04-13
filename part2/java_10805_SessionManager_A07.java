public class java_10805_SessionManager_A07 {
    private static SessionManager instance = null;
    private Session session = null;

    // Private constructor to prevent instantiation
    private java_10805_SessionManager_A07() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    // Singleton instance getter
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session getSession() {
        return session;
    }

    public void beginTransaction() {
        session.beginTransaction();
    }

    public void commitTransaction() {
        session.getTransaction().commit();
    }

    public void rollbackTransaction() {
        session.getTransaction().rollback();
    }
}