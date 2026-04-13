import java.util.HashMap;
import java.util.Map;

public class java_27375_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_27375_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        if (sessionExists(sessionId)) {
            throw new RuntimeException("Session already exists with id: " + sessionId);
        }

        Session session = new Session(sessionId);
        sessions.put(sessionId, session);

        return session;
    }

    public Session getSession(String sessionId) {
        if (!sessionExists(sessionId)) {
            throw new RuntimeException("Session does not exists with id: " + sessionId);
        }

        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        if (!sessionExists(sessionId)) {
            throw new RuntimeException("Session does not exists with id: " + sessionId);
        }

        sessions.remove(sessionId);
    }

    private boolean sessionExists(String sessionId) {
        return sessions.containsKey(sessionId);
    }
}