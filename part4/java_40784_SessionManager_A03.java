import java.util.*;

public class java_40784_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_40784_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public String createSession() {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session();
        sessions.put(sessionId, session);
        return sessionId;
    }

    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new IllegalArgumentException("Invalid session ID");
        }
        return session;
    }

    public void deleteSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new IllegalArgumentException("Invalid session ID");
        }
        sessions.remove(sessionId);
    }

    public static class Session {
        private String data;

        public java_40784_SessionManager_A03() {
            this.data = "";
        }

        public void setData(String data) {
            // In a real application, you would need to check for injection attacks
            this.data = data;
        }

        public String getData() {
            return this.data;
        }
    }
}