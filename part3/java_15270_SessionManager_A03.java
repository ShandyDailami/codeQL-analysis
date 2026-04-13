import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class java_15270_SessionManager_A03 {
    private ConcurrentHashMap<UUID, Session> sessionMap;

    public java_15270_SessionManager_A03() {
        this.sessionMap = new ConcurrentHashMap<>();
    }

    public UUID startSession() {
        UUID sessionId = UUID.randomUUID();
        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);
        return sessionId;
    }

    public Session getSession(UUID sessionId) {
        return sessionMap.get(sessionId);
    }

    public void stopSession(UUID sessionId) {
        Session session = sessionMap.remove(sessionId);
        if (session != null) {
            session.stop();
        }
    }

    private class Session {
        private UUID sessionId;
        private boolean isRunning = false;

        public java_15270_SessionManager_A03(UUID sessionId) {
            this.sessionId = sessionId;
        }

        public void start() {
            isRunning = true;
        }

        public void stop() {
            isRunning = false;
        }

        public boolean isRunning() {
            return isRunning;
        }
    }
}