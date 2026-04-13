import java.util.HashMap;
import java.util.Map;

public class java_04440_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_04440_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists for ID: " + sessionId);
        }

        Session session = new Session(sessionId);
        sessions.put(sessionId, session);

        return session;
    }

    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist for ID: " + sessionId);
        }

        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist for ID: " + sessionId);
        }

        sessions.remove(sessionId);
    }
}

class Session {
    private String id;

    public java_04440_SessionManager_A01(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}