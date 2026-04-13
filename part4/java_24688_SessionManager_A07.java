import java.util.HashMap;
import java.util.UUID;

public class java_24688_SessionManager_A07 {
    private HashMap<UUID, Session> sessions;

    public java_24688_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public UUID createSession() {
        UUID sessionId = UUID.randomUUID();
        sessions.put(sessionId, new Session());
        return sessionId;
    }

    public Session getSession(UUID sessionId) throws Exception {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            throw new Exception("Invalid session ID");
        }
    }

    public void invalidateSession(UUID sessionId) {
        sessions.remove(sessionId);
    }

    private class Session {
        // Session data here.
    }
}