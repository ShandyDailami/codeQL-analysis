import java.util.HashMap;
import java.util.UUID;

public class java_39730_SessionManager_A03 {
    private HashMap<UUID, Session> sessionMap;

    public java_39730_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public UUID startSession() {
        UUID sessionId = UUID.randomUUID();
        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);
        return sessionId;
    }

    public void endSession(UUID sessionId) {
        sessionMap.remove(sessionId);
    }

    public Session getSession(UUID sessionId) {
        return sessionMap.get(sessionId);
    }

    public class Session {
        private UUID sessionId;
        private long startTime;

        public java_39730_SessionManager_A03(UUID sessionId) {
            this.sessionId = sessionId;
            this.startTime = System.currentTimeMillis();
        }

        public UUID getSessionId() {
            return sessionId;
        }

        public long getSessionTime() {
            return System.currentTimeMillis() - startTime;
        }
    }
}