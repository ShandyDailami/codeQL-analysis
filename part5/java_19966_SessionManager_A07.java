import java.util.HashMap;
import java.util.Map;

public class java_19966_SessionManager_A07 {

    private Map<String, Session> sessions;

    public java_19966_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            sessions.put(sessionId, new Session(sessionId));
        }
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static class Session {

        private String sessionId;

        public java_19966_SessionManager_A07(String sessionId) {
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
        Session session = sessionManager.getSession("session1");
        session.setSessionId("newSession");
        System.out.println("Session ID: " + session.getSessionId());
        sessionManager.destroySession("session1");
        System.out.println("Destroy session: " + session.getSessionId());
    }
}