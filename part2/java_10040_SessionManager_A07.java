import java.util.HashMap;
import java.util.Map;

public class java_10040_SessionManager_A07 {
    private Map<String, Session> sessions;

    public java_10040_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public Session getSession(String userId) {
        Session session = sessions.get(userId);
        if (session == null) {
            session = new Session(userId);
            sessions.put(userId, session);
        }
        return session;
    }

    public void closeSession(String userId) {
        Session session = sessions.get(userId);
        if (session != null) {
            session.close();
            sessions.remove(userId);
        }
    }

    public static class Session {
        private String userId;
        private boolean isOpen;

        public java_10040_SessionManager_A07(String userId) {
            this.userId = userId;
            this.isOpen = true;
        }

        public void close() {
            isOpen = false;
        }

        public boolean isOpen() {
            return isOpen;
        }

        public String getUserId() {
            return userId;
        }
    }
}