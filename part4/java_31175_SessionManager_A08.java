import java.util.HashMap;
import java.util.Map;

public class java_31175_SessionManager_A08 {
    // A map to store session data.
    private Map<String, Session> sessions;

    // Constructor.
    public java_31175_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    // Add a session.
    public void addSession(Session session) {
        sessions.put(session.getId(), session);
    }

    // Remove a session.
    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    // Get a session.
    public Session getSession(String sessionId) {
        // This is a simple security measure. 
        // In a real-world application, you'd likely want to check the session data 
        // against a list of authorized users and revoke the session if it's not authorized.
        Session session = sessions.get(sessionId);
        // This check can be removed and the session can be destroyed in real-world applications.
        if(session != null && session.isValid()) {
            return session;
        }
        return null;
    }

    // Session class.
    public class Session {
        private String id;
        private boolean valid;

        // Constructor.
        public java_31175_SessionManager_A08(String id) {
            this.id = id;
            valid = true;
        }

        // Get the session id.
        public String getId() {
            return id;
        }

        // Check if the session is valid.
        public boolean isValid() {
            return valid;
        }

        // Set the session as invalid.
        public void invalidate() {
            valid = false;
        }
    }
}