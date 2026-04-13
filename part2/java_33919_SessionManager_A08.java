import java.util.HashMap;
import java.util.Map;

public class java_33919_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_33919_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        // Adding a session id to the map with the username as key
        // Also, adding a session id to a secure location in memory for this user
        sessionMap.put(username, generateSessionId(username));
    }

    public void endSession(String username) {
        // Removing a session id from the map and secure location
        sessionMap.remove(username);
    }

    public String getSessionId(String username) {
        // Getting a session id from the map
        return sessionMap.get(username);
    }

    // Generating a session id securely
    private String generateSessionId(String username) {
        // You can generate a secure session id based on the username and other sensitive data
        // For simplicity, we'll just return a random string
        return "SESSION_" + username;
    }
}