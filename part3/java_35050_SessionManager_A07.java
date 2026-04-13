import java.util.HashMap;
import java.util.Map;

public class java_35050_SessionManager_A07 {
    // Create a new map for storing user sessions
    private Map<String, String> sessionMap;

    public java_35050_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to authenticate a user
    public String authenticate(String username, String password) {
        // For the sake of this example, we'll just verify that the password is "secret"
        if (password.equals("secret")) {
            // Create a new session ID and store it in the map
            String sessionID = java.util.UUID.randomUUID().toString();
            sessionMap.put(sessionID, username);

            return sessionID;
        } else {
            return null;
        }
    }

    // Method to check if a user is authenticated
    public String isAuthenticated(String sessionID) {
        // Check if the session ID exists in the map
        if (sessionMap.containsKey(sessionID)) {
            // If it does, return the username
            return sessionMap.get(sessionID);
        } else {
            // If it doesn't, return null
            return null;
        }
    }
}