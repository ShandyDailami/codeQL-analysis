import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_29196_SessionManager_A08 {
    private Map<UUID, Session> sessionMap;

    public java_29196_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public UUID startSession() {
        UUID sessionId = UUID.randomUUID();
        Session session = new Session(sessionId, LocalDateTime.now());
        sessionMap.put(sessionId, session);
        return sessionId;
    }

    public void endSession(UUID sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session != null) {
            sessionMap.remove(sessionId);
        }
    }

    private class Session {
        private UUID id;
        private LocalDateTime creationTime;

        public java_29196_SessionManager_A08(UUID id, LocalDateTime creationTime) {
            this.id = id;
            this.creationTime = creationTime;
        }

        public LocalDateTime getCreationTime() {
            return creationTime;
        }

        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
        }

        public void setCreationTime(LocalDateTime creationTime) {
            this.creationTime = creationTime;
        }
    }
}