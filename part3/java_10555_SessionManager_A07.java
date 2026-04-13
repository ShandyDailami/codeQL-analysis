import java.util.HashMap;
import java.util.Map;

public class java_10555_SessionManager_A07 {

    // A map to store session IDs and User objects
    private Map<String, User> sessionMap;

    public java_10555_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        // Create a unique session ID
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, user);

        return sessionId;
    }

    // Method to get a user from a session
    public User getUser(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new IllegalArgumentException("Invalid session ID");
        }
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new IllegalArgumentException("Invalid session ID");
        }
    }
}