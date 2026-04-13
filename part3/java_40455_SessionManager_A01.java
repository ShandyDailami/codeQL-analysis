import java.util.HashMap;

public class java_40455_SessionManager_A01 {
    private HashMap<String, Session> sessionMap;

    public java_40455_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession() {
        Session session = new Session();
        String sessionId = session.getId();
        sessionMap.put(sessionId, session);
        return sessionId;
    }

    public Session getSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session == null) {
            throw new IllegalStateException("Session not found for sessionId: " + sessionId);
        }
        return session;
    }

    public void destroySession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session == null) {
            throw new IllegalStateException("Session not found for sessionId: " + sessionId);
        } else {
            sessionMap.remove(sessionId);
        }
    }

    public static class Session {
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}