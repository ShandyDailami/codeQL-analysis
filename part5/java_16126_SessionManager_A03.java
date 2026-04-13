import java.util.HashMap;
import java.util.Map;

public class java_16126_SessionManager_A03 {
    // SessionManager uses a HashMap to store sessions
    private Map<String, Session> sessions;

    // SessionManager constructor
    public java_16126_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    // Session class
    public class Session {
        private String userId;

        // Session constructor
        public java_16126_SessionManager_A03(String userId) {
            this.userId = userId;
        }

        // Get userId method
        public String getUserId() {
            return userId;
        }

        // Set userId method
        public void setUserId(String userId) {
            this.userId = userId;
        }
    }

    // StartSession method
    public Session startSession(String userId) {
        // Create a new session
        Session session = new Session(userId);

        // Add the new session to the sessions map
        sessions.put(userId, session);

        // Return the new session
        return session;
    }

    // GetSession method
    public Session getSession(String userId) {
        // Return the session from the sessions map
        return sessions.get(userId);
    }

    // EndSession method
    public void endSession(String userId) {
        // Remove the session from the sessions map
        sessions.remove(userId);
    }
}