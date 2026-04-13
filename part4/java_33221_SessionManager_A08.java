import java.util.HashMap;
import java.util.Map;

public class java_33221_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_33221_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            sessions.put(sessionId, new Session(sessionId));
        }

        return sessions.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
        }
    }

    private class Session {
        private String sessionId;

        public java_33221_SessionManager_A08(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Creating a session
        Session session1 = sessionManager.getSession("session1");
        System.out.println("Created session: " + session1.getSessionId());

        // Reusing the session
        Session session2 = sessionManager.getSession("session1");
        System.out.println("Reused session: " + session2.getSessionId());

        // Invalidate the session
        sessionManager.invalidateSession("session1");
        System.out.println("Invalidated session: " + session2.getSessionId());
    }
}