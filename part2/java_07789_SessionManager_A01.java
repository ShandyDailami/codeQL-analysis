import java.util.HashMap;

public class java_07789_SessionManager_A01 {
    private HashMap<String, Session> sessions;

    public java_07789_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessions.put(sessionId, new Session(username));
        return sessionId;
    }

    public String getUsername(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            return null;
        }
        return session.getUsername();
    }

    public void invalidateSession(String sessionId) {
        sessions.remove(sessionId);
    }

    private String generateSessionId() {
        return java.util.UUID.randomUUID().toString();
    }

    private class Session {
        private String username;

        public java_07789_SessionManager_A01(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }
}