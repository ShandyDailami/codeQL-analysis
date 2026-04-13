import java.util.HashMap;
import java.util.Map;

public class java_36490_SessionManager_A08 {

    // A simple SessionFactory
    private static Map<String, Session> sessions = new HashMap<>();

    // Static SessionManager
    private static SessionManager sessionManager;

    private java_36490_SessionManager_A08() { }

    public static SessionManager getInstance() {
        if(sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public Session getSession(String sessionId) throws SecurityFailureException {
        if (sessions.containsKey(sessionId)) {
            throw new SecurityFailureException("Integrity failure: Session " + sessionId + " already exists.");
        }

        Session session = new Session();
        sessions.put(sessionId, session);
        return session;
    }

    public void closeSession(String sessionId) throws SecurityFailureException {
        if (!sessions.containsKey(sessionId)) {
            throw new SecurityFailureException("Integrity failure: Session " + sessionId + " does not exists.");
        }

        sessions.remove(sessionId);
    }
}

public class Session {
    private String sessionId;

    public java_36490_SessionManager_A08(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}

public class SecurityFailureException extends Exception {
    public java_36490_SessionManager_A08(String message) {
        super(message);
    }
}