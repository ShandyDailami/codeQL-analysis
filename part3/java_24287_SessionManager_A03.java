public class java_24287_SessionManager_A03 {
    private static SessionManager instance;
    private Session currentSession;

    private java_24287_SessionManager_A03() {
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session getSession() {
        if (currentSession == null || currentSession.getStatus() == Session.Status.DELETED) {
            currentSession = HibernateUtil.getSessionFactory().openSession();
        }
        return currentSession;
    }

    public void closeSession() {
        if (currentSession != null && currentSession.getStatus() != Session.Status.CLOSED) {
            currentSession.close();
            currentSession = null;
        }
    }
}