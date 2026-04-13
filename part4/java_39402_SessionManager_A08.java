import java.util.HashMap;
import java.util.Map;

public class java_39402_SessionManager_A08 {

    // Map to store sessions
    private Map<String, Session> sessions;

    public java_39402_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    // Session class
    public class Session {
        private String id;
        private boolean valid;

        public java_39402_SessionManager_A08(String id) {
            this.id = id;
            this.valid = true;
        }

        public String getId() {
            return id;
        }

        public boolean isValid() {
            return valid;
        }

        public void invalidate() {
            valid = false;
        }
    }

    // Method to create a new session
    public Session createSession(String id) {
        Session session = new Session(id);
        sessions.put(id, session);
        return session;
    }

    // Method to get a session
    public Session getSession(String id) {
        Session session = sessions.get(id);
        if (session == null || session.isValid() == false) {
            System.out.println("Invalid session: " + id);
            return null;
        }
        return session;
    }

    // Method to invalidate a session
    public void invalidateSession(String id) {
        Session session = sessions.get(id);
        if (session == null) {
            System.out.println("No such session to invalidate: " + id);
            return;
        }
        session.invalidate();
    }
}