import java.util.HashMap;
import java.util.Map;

public class java_05115_SessionManager_A03 {

    // Use a HashMap to store sessions. The key is the user ID, and the value is the session.
    private Map<String, Session> sessions;

    // Constructor
    public java_05115_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    // Method to create a session for a user.
    public Session createSession(String userId) {
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }

        // Verify the user ID. This could be a more complex security check.
        // In this case, we'll just check that the user ID is not already in the map.
        if (sessions.containsKey(userId)) {
            throw new IllegalStateException("A session for the user with ID " + userId + " already exists");
        }

        // Create a new session and store it in the map.
        Session session = new Session(userId);
        sessions.put(userId, session);

        return session;
    }

    // Method to get a session for a user.
    public Session getSession(String userId) {
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }

        // Verify the user ID. This could be a more complex security check.
        // In this case, we'll just check that the user ID is in the map.
        if (!sessions.containsKey(userId)) {
            throw new IllegalStateException("No session for the user with ID " + userId);
        }

        // Return the session for the user.
        return sessions.get(userId);
    }

    // Session class.
    public class Session {
        private String userId;

        public java_05115_SessionManager_A03(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }
    }
}