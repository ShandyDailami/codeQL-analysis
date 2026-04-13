import java.util.HashMap;
import java.util.Map;

public class java_15033_SessionManager_A03 {
    // The sessionMap is used to store session objects.
    private Map<String, Session> sessionMap;

    // Constructor
    public java_15033_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        // Check if session already exists
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            Session session = new Session(sessionId);
            sessionMap.put(sessionId, session);
            return session;
        }
    }

    // Session class
    public class Session {
        private String sessionId;

        public java_15033_SessionManager_A03(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Get a session
        Session session1 = sessionManager.getSession("Session1");
        System.out.println(session1.getSessionId());

        Session session2 = sessionManager.getSession("Session2");
        System.out.println(session2.getSessionId());
    }
}