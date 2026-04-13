import java.util.HashMap;
import java.util.Map;

public class java_16072_SessionManager_A08 {
    private Map<String, Session> sessionMap;

    public java_16072_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session == null) {
            session = new Session(sessionId);
            sessionMap.put(sessionId, session);
        }
        return session;
    }

    public void closeSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session != null) {
            sessionMap.remove(sessionId);
            session.close();
        }
    }

    public class Session {
        private String sessionId;

        public java_16072_SessionManager_A08(String sessionId) {
            this.sessionId = sessionId;
        }

        public void close() {
            System.out.println("Closing session: " + sessionId);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Creating a new session.
        Session session1 = sessionManager.getSession("session1");

        // Using an existing session.
        Session session2 = sessionManager.getSession("session2");

        // Closing the session.
        sessionManager.closeSession("session1");
    }
}