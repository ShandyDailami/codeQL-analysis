import java.util.HashMap;
import java.util.Map;

public class java_25985_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_25985_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        if (sessionExists(sessionId)) {
            throw new RuntimeException("Session with ID " + sessionId + " already exists.");
        }

        Session session = new Session(sessionId);
        sessions.put(sessionId, session);

        return session;
    }

    public Session getSession(String sessionId) {
        if (!sessionExists(sessionId)) {
            throw new RuntimeException("No session with ID " + sessionId + " exists.");
       
        }

        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        if (!sessionExists(sessionId)) {
            throw new RuntimeException("No session with ID " + sessionId + " exists.");
        }

        sessions.remove(sessionId);
    }

    private boolean sessionExists(String sessionId) {
        return sessions.containsKey(sessionId);
    }
}