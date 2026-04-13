import java.util.HashMap;
import java.util.Map;

public class java_29545_SessionManager_A08 {
    private Map<String, Session> sessionMap;

    public java_29545_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void closeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void createSession(String sessionId) {
        sessionMap.put(sessionId, new Session(sessionId));
    }

    public static class Session {
        private String id;

        public java_29545_SessionManager_A08(String id) {
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

public class Main {
    public static void main(String[] args) {
        CustomSessionManager sessionManager = new CustomSessionManager();

        // Creating a new session
        sessionManager.createSession("session1");

        // Getting a session
        CustomSessionManager.Session session = sessionManager.getSession("session1");
        System.out.println("Session ID: " + session.getId());

        // Closing a session
        sessionManager.closeSession("session1");
    }
}