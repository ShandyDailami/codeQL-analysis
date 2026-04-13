import java.util.HashMap;
import java.util.Map;

public class java_14404_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_14404_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public String createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return "Session with ID " + sessionId + " already exists.";
        }
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return "Session with ID " + sessionId + " created successfully.";
    }

    public String getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            Session session = sessions.get(sessionId);
            return "Session with ID " + sessionId + " is valid. Last accessed: " + session.getLastAccessed();
        } else {
            return "Session with ID " + sessionId + " does not exist.";
        }
    }

    public String deleteSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
            return "Session with ID " + sessionId + " deleted successfully.";
        } else {
            return "Session with ID " + sessionId + " does not exist.";
        }
    }

    private static class Session {
        private String id;
        private long creationTime;

        public java_14404_SessionManager_A03(String id) {
            this.id = id;
            this.creationTime = System.currentTimeMillis();
        }

        public String getId() {
            return id;
        }

        public long getLastAccessed() {
            return System.currentTimeMillis() - creationTime;
        }
    }
}