import java.util.HashMap;
import java.util.Map;

public class java_28435_SessionManager_A08 {
    // A map to hold the sessions
    private Map<String, Session> sessionMap;

    // Constructor
    public java_28435_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to add a session
    public String addSession(Session session) {
        if (session == null) {
            throw new IllegalArgumentException("Session cannot be null");
        }

        String sessionId = session.getId();
        if (sessionId == null) {
            sessionId = generateSessionId(session);
        } else {
            if (sessionMap.containsKey(sessionId)) {
                throw new IllegalArgumentException("Session already exists with id " + sessionId);
            }
        }

        sessionMap.put(sessionId, session);
        return sessionId;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Session id cannot be null");
        }

        return sessionMap.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Session id cannot be null");
        }

        sessionMap.remove(sessionId);
    }

    // Method to generate a session id
    private String generateSessionId(Session session) {
        // This is a placeholder for actual session id generation.
        // In a real-world application, you would use a UUID generator or a similar method.
        return session.hashCode() + "";
    }
}