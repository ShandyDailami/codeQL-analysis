import java.util.*;

public class java_07639_SessionManager_A08 {
    private Hashtable<UUID, Session> sessions;

    public java_07639_SessionManager_A08() {
        sessions = new Hashtable<>();
    }

    public Session getSession(UUID sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            Session session = new Session(sessionId);
            sessions.put(sessionId, session);
            return session;
        }
    }

    public void closeSession(UUID sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
        }
    }

    public void closeAllSessions() {
        sessions.clear();
    }

    private class Session {
        private UUID sessionId;

        public java_07639_SessionManager_A08(UUID sessionId) {
            this.sessionId = sessionId;
        }

        public UUID getSessionId() {
            return sessionId;
        }

        // Additional methods for session...
    }
}