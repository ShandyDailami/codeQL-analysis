import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.UUID;

public class java_15412_SessionManager_A07 {
    private HashMap<UUID, Session> sessions;

    public java_15412_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public UUID startSession() {
        UUID sessionId = UUID.randomUUID();
        Session session = new Session(sessionId, LocalDateTime.now());
        sessions.put(sessionId, session);
        return sessionId;
    }

    public void endSession(UUID sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null) {
            session.setLastActivity(LocalDateTime.now());
            sessions.remove(sessionId);
        }
    }

    // Session class
    private static class Session {
        private UUID sessionId;
        private LocalDateTime creationTime;
        private LocalDateTime lastActivity;

        public java_15412_SessionManager_A07(UUID sessionId, LocalDateTime creationTime) {
            this.sessionId = sessionId;
            this.creationTime = creationTime;
            this.lastActivity = creationTime;
        }

        public void setLastActivity(LocalDateTime lastActivity) {
            this.lastActivity = lastActivity;
        }
    }
}