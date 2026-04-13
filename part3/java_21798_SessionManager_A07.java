import java.util.HashMap;
import java.util.Map;

public class java_21798_SessionManager_A07 {
    // A simple in-memory store for session data.
    private Map<String, Session> sessionMap;

    public java_21798_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("Session already exists!");
        }
        Session session = new Session();
        sessionMap.put(sessionId, session);
    }

    public Session getSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("Session does not exist!");
        }
        return sessionMap.get(sessionId);
    }

    public void stopSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("Session does not exist!");
        }
        sessionMap.remove(sessionId);
    }

    public class Session {
        // Here we're assuming a simple data structure for demonstration.
        private String user;

        public java_21798_SessionManager_A07() {
            user = null;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getUser() {
            return user;
        }
    }
}