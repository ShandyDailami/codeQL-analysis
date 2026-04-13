public class java_22472_SessionManager_A01 {
    private static SessionManager instance;
    private Session currentSession;

    private java_22472_SessionManager_A01() {
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void startSession() {
        if (currentSession == null || currentSession.isDestroyed()) {
            currentSession = Session.getSessionFactory().openSession();
        }
    }

    public void endSession() {
        if (currentSession != null && !currentSession.isDestroyed()) {
            currentSession.close();
            currentSession = null;
        }
    }

    public Session getCurrentSession() {
        return currentSession;
    }
}