import java.util.*;

public class java_21931_SessionManager_A01 {
    private Map<UUID, Session> sessions;

    public java_21931_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public Session createSession() {
        Session session = new Session();
        UUID sessionId = UUID.randomUUID();
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(UUID sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(UUID sessionId) {
        sessions.remove(sessionId);
    }

    // Session class
    public static class Session {
        private String user;

        public java_21931_SessionManager_A01(String user) {
            this.user = user;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }
    }
}