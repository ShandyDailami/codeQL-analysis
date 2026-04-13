import java.util.HashMap;
import java.util.UUID;

public class java_18289_SessionManager_A07 {
    private HashMap<UUID, Session> sessions;

    public java_18289_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public UUID createSession() {
        UUID sessionId = UUID.randomUUID();
        sessions.put(sessionId, new Session(sessionId));
        return sessionId;
    }

    public Session getSession(UUID sessionId) {
        return sessions.get(sessionId);
    }

    public void closeSession(UUID sessionId) {
        sessions.remove(sessionId);
    }

    public class Session {
        private UUID sessionId;

        public java_18289_SessionManager_A07(UUID sessionId) {
            this.sessionId = sessionId;
        }

        public UUID getSessionId() {
            return sessionId;
        }

        public void setSessionId(UUID sessionId) {
            this.sessionId = sessionId;
        }
    }
}