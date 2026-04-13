import java.util.*;

public class java_19906_SessionManager_A07 {

    private Map<UUID, Session> sessions;

    public java_19906_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public Session getSession(UUID sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            session = new Session(sessionId);
            sessions.put(sessionId, session);
        }
        return session;
    }

    public void removeSession(UUID sessionId) {
        sessions.remove(sessionId);
    }

    public static class Session {

        private UUID sessionId;

        public java_19906_SessionManager_A07(UUID sessionId) {
            this.sessionId = sessionId;
        }

        public UUID getSessionId() {
            return sessionId;
        }

        public void invalidateSession() {
            // Invalidate session here
        }

        public void setSessionId(UUID sessionId) {
            this.sessionId = sessionId;
        }
    }
}