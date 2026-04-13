public class java_35145_SessionManager_A08 {
    private static SessionManager instance;
    private Session session;

    private java_35145_SessionManager_A08() {
        // Load the driver if not already loaded
        // You would need to replace this with a call to a method that loads the driver
        // for example: sessionFactory.getCurrentSession().getClass().newInstance()
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session getSession() {
        if (session == null || session.isClosed()) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    public void closeSession() {
        session.close();
        session = null;
    }
}