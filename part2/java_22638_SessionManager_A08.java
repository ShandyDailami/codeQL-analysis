import java.util.HashMap;
import java.util.Map;

public class java_22638_SessionManager_A08 {
    private Map<String, Session> sessionMap;

    public java_22638_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession() {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);
        return sessionId;
    }

    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session != null) {
            session.end();
        }
        sessionMap.remove(sessionId);
    }

    private class Session {
        private String sessionId;
        private long creationTime;

        public java_22638_SessionManager_A08(String sessionId) {
            this.sessionId = sessionId;
            this.creationTime = System.currentTimeMillis();
        }

        public void end() {
            // This is a dummy implementation for illustrative purposes.
            // In real-world applications, it would involve logging the session,
            // potentially clearing session data, and possibly removing the session
            // from the session manager.
            System.out.println("Session " + sessionId + " ended.");
        }
    }
}