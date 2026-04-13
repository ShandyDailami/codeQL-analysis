import java.util.HashMap;
import java.util.Map;

public class java_25362_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_25362_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public Session openSession(String username) {
        Session session = new Session(username);
        sessions.put(username, session);
        return session;
    }

    public void closeSession(String username) {
        Session session = sessions.get(username);
        if (session != null) {
            sessions.remove(username);
        }
    }

    public Session getSession(String username) {
        Session session = sessions.get(username);
        if (session != null && session.isOpen()) {
            return session;
        } else {
            throw new SecurityException("Access denied for user: " + username);
        }
    }

    private class Session {
        private String username;
        private boolean open;

        public java_25362_SessionManager_A01(String username) {
            this.username = username;
            this.open = true;
        }

        public boolean isOpen() {
            return open;
        }

        public void close() {
            open = false;
        }

        public String getUsername() {
            return username;
        }
    }
}