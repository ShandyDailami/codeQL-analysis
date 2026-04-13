import java.util.HashMap;
import java.util.Map;

public class java_07714_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_07714_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session getSession(String username) {
        if (sessions.containsKey(username)) {
            return sessions.get(username);
        } else {
            Session session = new Session(username);
            sessions.put(username, session);
            return session;
        }
    }

    public void closeSession(String username) {
        if (sessions.containsKey(username)) {
            sessions.get(username).close();
            sessions.remove(username);
        }
    }

    private class Session {
        private String username;

        public java_07714_SessionManager_A08(String username) {
            this.username = username;
        }

        public void close() {
            // Placeholder for closing a session
        }
    }
}