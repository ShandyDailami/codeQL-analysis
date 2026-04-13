public class java_00999_SessionManager_A07 {
    // The key to use for session management
    private static final String SESSION_KEY = "sessionId";

    // Session object
    private Session session;

    // Constructor to initialize the session object
    public java_00999_SessionManager_A07() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    // Method to get a session
    public Session getSession() {
        return session;
    }

    // Method to set a session
    public void setSession(Session session) {
        this.session = session;
    }

    // Method to start a session
    public void startSession() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to commit a session
    public void commitSession() {
        try {
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to rollback a session
    public void rollbackSession() {
        try {
            session.getTransaction().rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to close a session
    public void closeSession() {
        session.close();
    }
}