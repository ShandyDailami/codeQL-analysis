import java.util.HashMap;
import java.util.Map;

public class java_07744_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_07744_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            Session newSession = new Session(sessionId);
            sessions.put(sessionId, newSession);
            return newSession;
        }
    }

    public void invalidateSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.get(sessionId).invalidate();
        }
    }

    public static class Session {
        private String id;
        private boolean isValid;

        public java_07744_SessionManager_A03(String id) {
            this.id = id;
            this.isValid = true;
        }

        public void invalidate() {
            this.isValid = false;
        }

        public String getId() {
            return this.id;
        }

        public boolean isValid() {
            return this.isValid;
        }
    }
}