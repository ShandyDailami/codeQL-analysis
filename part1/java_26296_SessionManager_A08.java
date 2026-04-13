import java.util.HashMap;

public class java_26296_SessionManager_A08 {
    private HashMap<String, Session> sessionMap;

    public java_26296_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists with ID: " + sessionId);
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Creating new session with ID: " + sessionId);
            Session session = new Session(sessionId);
            sessionMap.put(sessionId, session);
            return session;
        }
    }

    public void closeSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Closing session with ID: " + sessionId);
            sessionMap.remove(sessionId);
        } else {
            System.out.println("No session exists with ID: " + sessionId);
        }
    }

    // Session class
    class Session {
        private String sessionId;

        public java_26296_SessionManager_A08(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }
    }
}