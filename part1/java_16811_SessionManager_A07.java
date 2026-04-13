import java.util.HashMap;
import java.util.Map;

public class java_16811_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_16811_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        // Generate a unique session ID for this user
        String sessionId = generateSessionId(username);

        // Store the session ID and username in the session map
        sessionMap.put(sessionId, username);

        // Print a message to indicate a new session has started
        System.out.println("Session started for user: " + username);
    }

    public void endSession(String sessionId) {
        // Retrieve the username from the session map
        String username = sessionMap.get(sessionId);

        // If the session map contains this session ID, remove it
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }

        // Print a message to indicate a session has ended
        System.out.println("Session ended for user: " + username);
    }

    private String generateSessionId(String username) {
        // Simple session ID generation. In a real-world application,
        // this would likely be a more complex process that includes
        // the user's ID, the current time, and some other random
        // data to ensure uniqueness
        return username;
    }
}