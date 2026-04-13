import java.util.HashMap;
import java.util.Map;

public class java_26815_SessionManager_A07 {
    // Step 1: Create a private HashMap to hold the sessions
    private Map<String, String> sessionMap;

    public java_26815_SessionManager_A07() {
        // Step 2: Initialize the session map
        sessionMap = new HashMap<>();
    }

    // Step 3: Create a method to create a session
    public String createSession(String user) {
        // Step 4: Generate a unique session ID
        String sessionId = java.util.UUID.randomUUID().toString();

        // Step 5: Add the session to the map
        sessionMap.put(sessionId, user);

        // Step 6: Return the session ID
        return sessionId;
    }

    // Step 7: Create a method to get the user from a session
    public String getUserFromSession(String sessionId) {
        // Step 8: Check if the session exists in the map
        if (sessionMap.containsKey(sessionId)) {
            // Step 9: Return the user from the session
            return sessionMap.get(sessionId);
        } else {
            // Step 10: Return null if the session does not exist
            return null;
        }
    }

    // Step 11: Create a method to remove a session
    public void removeSession(String sessionId) {
        // Step 12: Remove the session from the map
        sessionMap.remove(sessionId);
    }
}