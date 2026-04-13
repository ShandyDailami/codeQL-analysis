public class java_23529_SessionManager_A08 {
    private static SessionManager sessionManager = null;
    private Session session = null;

    private java_23529_SessionManager_A08() {
        // create a session
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public static SessionManager getSessionManager() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public void save(Object object) {
        // begin a transaction
        session.beginTransaction();

        // save the object
        session.save(object);

        // commit the transaction
        session.getTransaction().commit();
    }
}