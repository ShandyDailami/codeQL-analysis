import java.util.HashMap;
import java.util.Map;

public class java_02464_SessionManager_A08 {
    // Create a HashMap to store session objects
    private Map<String, Session> sessionMap;

    // Constructor
    public java_02464_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public Session createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session with id " + sessionId + " already exists.");
            return null;
        }

        Session session = new Session();
        session.setSessionId(sessionId);
        sessionMap.put(sessionId, session);

        return session;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Session with id " + sessionId + " does not exists.");
            return null;
        }

        return sessionMap.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Session with id " + sessionId + " does not exists.");
            return;
        }

        sessionMap.remove(sessionId);
    }

    // Session class
    public class Session {
        private String sessionId;

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }
    }
}