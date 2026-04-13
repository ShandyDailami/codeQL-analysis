import java.util.HashMap;
import java.util.Map;

public class java_02218_SessionManager_A07 {
    // Create a private map to store user sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_02218_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userName) {
        // Generate a session token and store it in the map
        String sessionToken = UUID.randomUUID().toString();
        sessionMap.put(sessionToken, userName);

        // Return the session token
        return sessionToken;
    }

    // Method to validate a session
    public String validateSession(String sessionToken) {
        // Check if the session token exists in the map
        if(sessionMap.containsKey(sessionToken)) {
            // Return the user name associated with the session token
            return sessionMap.get(sessionToken);
        } else {
            // Return null if the session token is not valid
            return null;
        }
    }

    // Method to end a session
    public void endSession(String sessionToken) {
        // Remove the session token from the map
        sessionMap.remove(sessionToken);
    }
}