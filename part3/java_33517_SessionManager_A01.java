import java.util.HashMap;
import java.util.Map;

public class java_33517_SessionManager_A01 {
    private Map<String, Session> sessionMap;

    public java_33517_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return "Error: Session with ID " + sessionId + " already exists.";
        } else {
            Session session = new Session(sessionId);
            sessionMap.put(sessionId, session);
            return "Successfully created session with ID " + sessionId;
        }
    }

    public Session getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public String destroySession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return "Successfully destroyed session with ID " + sessionId;
        } else {
            return "Error: No session with ID " + sessionId + " exists.";
        }
    }

    // This is a very simple class, a real session manager would need to handle thread safety,
    // transaction management, user authentication, more complex data storage and retrieval,
    // and more.
    private class Session {
        private String id;

        public java_33517_SessionManager_A01(String id) {
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