import java.util.HashMap;
import java.util.Map;

public class java_29419_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_29419_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new SecurityException("Attempt to access a session that does not exist");
        }
        return sessions.get(sessionId);
    }

    public void createSession(String sessionId) {
        sessions.put(sessionId, new Session(sessionId));
    }

    public void destroySession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new SecurityException("Attempt to destroy a session that does not exist");
        }
        sessions.remove(sessionId);
    }
}

class Session {
    private String sessionId;

    public java_29419_SessionManager_A08(String sessionId) {
        this.sessionId = sessionId;
    }

    // getters and setters for sessionId
}