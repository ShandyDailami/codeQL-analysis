import java.util.HashMap;

public class java_07416_SessionManager_A01 {
    private HashMap<String, Session> sessions;

    public java_07416_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return "Session with id " + sessionId + " already exists.";
        } else {
            sessions.put(sessionId, new Session(sessionId));
            return "Session created with id " + sessionId;
        }
    }

    public String getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return "Session with id " + sessionId + " exists.";
        } else {
            return "Session with id " + sessionId + " does not exist.";
        }
    }

    public String removeSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
            return "Session with id " + sessionId + " removed.";
        } else {
            return "Session with id " + sessionId + " does not exist.";
        }
    }

    public class Session {
        private String id;

        public java_07416_SessionManager_A01(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}