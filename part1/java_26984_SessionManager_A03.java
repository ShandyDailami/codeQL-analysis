import java.util.*;

public class java_26984_SessionManager_A03 {
    private Map<UUID, Session> sessions;

    public java_26984_SessionManager_A03() {
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

    public void removeSession(UUID sessionId) {
        sessions.remove(sessionId);
    }

    public static class Session {
        private UUID sessionId;

        public java_26984_SessionManager_A03(UUID sessionId) {
            this.sessionId = sessionId;
        }

        public UUID getSessionId() {
            return sessionId;
        }
    }
}