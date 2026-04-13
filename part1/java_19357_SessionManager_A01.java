public class java_19357_SessionManager_A01 {
    // Static variable to hold the session
    private static Session session;

    // Singleton pattern to ensure only one session is created
    private java_19357_SessionManager_A01() {}

    private static SessionManager instance = null;

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    // Method to open a session
    public Session openSession() {
        if (session == null || !session.isOpen()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        return session;
    }

    // Method to close the session
    public void closeSession() {
        if (session != null && session.isOpen()) {
            session.close();
            session = null;
        }
    }
}