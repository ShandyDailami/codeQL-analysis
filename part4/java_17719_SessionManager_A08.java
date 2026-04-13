import java.util.HashMap;
import java.util.Map;

public class java_17719_SessionManager_A08 {

    // Using a HashMap to store session IDs and their corresponding User objects
    private Map<String, User> sessionMap;

    public java_17719_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(User user) {
        // Generate a unique session ID
        String sessionId = generateUniqueSessionId();

        // Store the user and session ID in the session map
        sessionMap.put(sessionId, user);

        return sessionId;
    }

    // Method to retrieve a user from a session
    public User getUserFromSession(String sessionId) {
        // Validate the session ID
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalArgumentException("Invalid session ID");
        }

        // Return the user corresponding to the session ID
        return sessionMap.get(sessionId);
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionId) {
        // Validate the session ID
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalArgumentException("Invalid session ID");
       
        }

        // Remove the session from the session map
        sessionMap.remove(sessionId);
    }

    // Helper method to generate a unique session ID
    private String generateUniqueSessionId() {
        // Insert your own session ID generation logic here
        // This is a placeholder and just generates a random string for simplicity
        return String.valueOf(Math.random());
    }
}

class User {
    // User attributes
    private String username;
    private String password;

    // Constructor
    public java_17719_SessionManager_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}