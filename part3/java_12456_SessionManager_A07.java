import java.util.HashMap;
import java.util.Map;

public class java_12456_SessionManager_A07 {
    // We'll use a HashMap as our session storage
    private Map<String, String> sessionStorage = new HashMap<>();

    // This method creates a new session for a user
    public String createSession(String username) {
        // Generate a session key that is unique for this user
        String sessionKey = username + System.currentTimeMillis();

        // Store the session key and username in the session storage
        sessionStorage.put(sessionKey, username);

        // Return the session key
        return sessionKey;
    }

    // This method retrieves the username for a given session key
    public String getUsername(String sessionKey) {
        // Return the username stored in the session storage for the given session key
        return sessionStorage.get(sessionKey);
    }

    // This method validates a session
    public boolean validateSession(String sessionKey) {
        // Check if the session key is in the session storage
        if (sessionStorage.containsKey(sessionKey)) {
            // Return true, indicating that the session is valid
            return true;
        } else {
            // Return false, indicating that the session is invalid
            return false;
        }
    }

    // This method destroys a session
    public void destroySession(String sessionKey) {
        // Remove the session key from the session storage
        sessionStorage.remove(sessionKey);
    }
}