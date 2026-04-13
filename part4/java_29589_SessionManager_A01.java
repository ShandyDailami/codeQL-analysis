public class java_29589_SessionManager_A01 {
    private static SessionManager instance;
    private Session currentSession;

    private java_29589_SessionManager_A01() {
        // Create new session and start it
        currentSession = new SessionImpl();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void startSession() {
        // Start a new session if it's not already started
        if (currentSession.isStarted()) {
            throw new RuntimeException("Session already started");
        }
        currentSession.start();
    }

    public void endSession() {
        // End the current session if it's started
        if (!currentSession.isStarted()) {
            throw new RuntimeException("Session not started");
        }
        currentSession.end();
    }

    public void destroySession() {
        // End the current session and release resources
        if (currentSession.isStarted()) {
            currentSession.end();
            instance = null;
            currentSession = null;
        }
    }
}