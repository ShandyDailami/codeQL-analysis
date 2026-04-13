public class java_32859_SessionManager_A08 {
    private static SessionManager instance;
    private Session session;

    private java_32859_SessionManager_A08() {
        // Private constructor to restrict instantiation of this class
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void openSession() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void closeSession() {
        session.close();
    }

    public Session getSession() {
        return session;
    }
}