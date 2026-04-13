import java.util.ArrayList;
import java.util.List;

public class java_40852_SessionManager_A07 {
    // List to store sessions
    private List<Session> sessions;

    // Default constructor
    public java_40852_SessionManager_A07() {
        sessions = new ArrayList<>();
    }

    // Method to create a session
    public Session createSession() {
        Session session = new Session();
        sessions.add(session);
        return session;
    }

    // Method to validate a session
    public boolean validateSession(String sessionId) {
        for (Session session : sessions) {
            if (session.getId().equals(sessionId)) {
                return true;
            }
        }
        return false;
    }

    // Session class
    public class Session {
        private String id;

        // Getter and setter methods
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}