import java.util.ArrayList;
import java.util.List;

public class java_03614_SessionManager_A03 {
    // Private list to store active sessions
    private List<Session> sessions;

    // Constructor
    public java_03614_SessionManager_A03() {
        sessions = new ArrayList<>();
    }

    // Method to create a new session
    public Session createSession() {
        Session session = new Session();
        sessions.add(session);
        return session;
    }

    // Method to remove a session
    public void removeSession(Session session) {
        sessions.remove(session);
    }

    // Session class
    public class Session {
        // Fields
        private String id;
        private boolean isActive;

        // Constructor
        public java_03614_SessionManager_A03() {
            // Generate a unique id for the session
            this.id = java.util.UUID.randomUUID().toString();
            this.isActive = true;
        }

        // Getters and setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isActive() {
            return isActive;
        }

        public void setActive(boolean active) {
            isActive = active;
        }

        // Method to deactivate the session
        public void deactivateSession() {
            setActive(false);
        }
    }
}