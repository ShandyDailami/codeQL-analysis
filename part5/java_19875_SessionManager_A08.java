import java.util.HashMap;
import java.util.Map;

public class java_19875_SessionManager_A08 {
    // Create a private Map to store sessions.
    private Map<String, Session> sessions;

    // Constructor
    public java_19875_SessionManager_A08() {
        this.sessions = new HashMap<>();
    }

    // Method to start a session
    public Session startSession(String username) {
        if (this.sessions.containsKey(username)) {
            throw new IllegalStateException("A session already exists for this username");
        }

        Session session = new Session(username);
        this.sessions.put(username, session);

        return session;
    }

    // Method to end a session
    public void endSession(String username) {
        if (!this.sessions.containsKey(username)) {
            throw new IllegalStateException("No session exists for this username");
        }

        this.sessions.remove(username);
    }

    // Session class
    public class Session {
        private String username;

        public java_19875_SessionManager_A08(String username) {
            this.username = username;
        }

        // Getters and Setters for username
        public String getUsername() {
            return this.username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}