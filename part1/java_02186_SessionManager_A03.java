import java.util.HashMap;

public class java_02186_SessionManager_A03 {
    // Step 1: Declare a HashMap to store sessions
    private HashMap<String, String> sessionMap;

    // Step 2: Initialize the session map
    public java_02186_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Step 3: Method to create a new session
    public String createSession(String userId) {
        // Generate a random session id
        String sessionId = userId + "_" + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Step 4: Method to get the user id from a session
    public String getUserIdFromSession(String sessionId) {
        // Check if the session id exists in the map
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            // In case of invalid session, return null
            return null;
        }
    }

    // Step 5: Method to destroy a session
    public void destroySession(String sessionId) {
        // Remove the session from the map
        sessionMap.remove(sessionId);
    }
}