import java.util.HashMap;

public class java_39546_SessionManager_A01 {
    private HashMap<String, Session> sessions;

    public java_39546_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return "Error: Session already exists";
        } else {
            sessions.put(sessionId, new Session(sessionId));
            return "Session created successfully";
        }
    }

    public String getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId).toString();
        } else {
            return "Error: Session does not exist";
        }
    }

    public String destroySession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
            return "Session destroyed successfully";
        } else {
            return "Error: Session does not exist";
        }
    }

    public static class Session {
        private String sessionId;

        public java_39546_SessionManager_A01(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        @Override
        public String toString() {
            return "Session ID: " + sessionId;
        }
    }
}