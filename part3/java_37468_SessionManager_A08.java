import java.time.LocalDateTime;
import java.util.Map;
import java.util.HashMap;

public class java_37468_SessionManager_A08 {
    private Map<String, Session> sessionMap;

    public java_37468_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public class Session {
        private String sessionId;
        private LocalDateTime creationTime;
        private LocalDateTime expirationTime;

        public java_37468_SessionManager_A08(String sessionId, LocalDateTime creationTime, LocalDateTime expirationTime) {
            this.sessionId = sessionId;
            this.creationTime = creationTime;
            this.expirationTime = expirationTime;
        }

        public String getSessionId() {
            return sessionId;
        }

        public LocalDateTime getCreationTime() {
            return creationTime;
        }

        public LocalDateTime getExpirationTime() {
            return expirationTime;
        }
    }

    public String createSession(LocalDateTime creationTime, LocalDateTime expirationTime) {
        String sessionId = java.util.UUID.randomUUID().toString();
        Session session = new Session(sessionId, creationTime, expirationTime);
        sessionMap.put(sessionId, session);
        return sessionId;
    }

    public boolean checkIntegrity(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            return false;
        }

        Session session = sessionMap.get(sessionId);
        LocalDateTime now = LocalDateTime.now();

        if (session.getExpirationTime().isBefore(now)) {
            return false;
        }

        if (session.getCreationTime().isAfter(now)) {
            return false;
        }

        return true;
    }
}