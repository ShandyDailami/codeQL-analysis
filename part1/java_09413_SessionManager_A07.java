import java.util.HashMap;
import java.util.Map;

public class java_09413_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_09413_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        // Create a session key based on the userId
        String sessionKey = userId;

        // Add the session key and userId to the session map
        sessionMap.put(sessionKey, userId);
    }

    public String getSession(String sessionKey) {
        // Retrieve the userId based on the session key
        return sessionMap.get(sessionKey);
    }

    public void endSession(String sessionKey) {
        // Remove the session key from the session map
        sessionMap.remove(sessionKey);
    }

    public void checkSession(String sessionKey) {
        // Check if the session key is in the session map
        if (sessionMap.containsKey(sessionKey)) {
            // If the session key is in the map, print a message
            System.out.println("Session found: " + sessionKey);
        } else {
            // If the session key is not in the map, print a message
            System.out.println("No session found for: " + sessionKey);
        }
    }
}