import java.util.HashMap;
import java.util.Map;

public class java_00441_SessionManager_A08 {

    private Map<String, Session> sessions;

    public java_00441_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session openSession(String username) {
        Session session = new Session(username);
        sessions.put(username, session);
        return session;
    }

    public Session getSession(String username) {
        return sessions.get(username);
    }

    public void closeSession(String username) {
        Session session = sessions.get(username);
        if (session != null) {
            session.close();
            sessions.remove(username);
        }
    }

    public void validateSession(String username) throws SecurityFailureException {
        Session session = sessions.get(username);
        if (session == null || !session.isOpen()) {
            throw new SecurityFailureException("Invalid session: " + username);
        }
    }

    private class Session {

        private String username;
        private boolean open;

        public java_00441_SessionManager_A08(String username) {
            this.username = username;
            open = true;
        }

        public void close() {
            open = false;
        }

        public boolean isOpen() {
            return open;
        }
    }

    private class SecurityFailureException extends Exception {
        public java_00441_SessionManager_A08(String message) {
            super(message);
        }
    }
}