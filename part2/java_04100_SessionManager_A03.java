import java.util.HashMap;

public class java_04100_SessionManager_A03 {
    private HashMap<String, Session> sessionMap;

    public java_04100_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            throw new IllegalStateException("Session already exists for user: " + userId);
        }

        Session session = new Session(userId);
        sessionMap.put(userId, session);
        return session.getId();
    }

    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void closeSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session == null) {
            throw new IllegalStateException("No session found with ID: " + sessionId);
        }

        sessionMap.remove(sessionId);
    }

    private class Session {
        private String id;

        public java_04100_SessionManager_A03(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}