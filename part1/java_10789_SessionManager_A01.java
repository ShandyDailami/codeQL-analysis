public class java_10789_SessionManager_A01 {

    private static int count = 0;
    private static SessionManager instance;
    private Session session;

    private java_10789_SessionManager_A01() {
        // Private constructor to prevent instantiation
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void openSession() {
        if (count == 0) {
            // Open a session if this is the first one.
            session = HibernateUtil.getSessionFactory().openSession();
        }
        count++;
    }

    public void closeSession() {
        count--;
        if (count == 0) {
            // Close the session if this is the last one.
            session.close();
        }
    }

    public Session getSession() {
        return session;
    }

}