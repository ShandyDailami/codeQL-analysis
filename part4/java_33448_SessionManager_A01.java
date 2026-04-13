import java.util.HashMap;
import java.util.Map;

public class java_33448_SessionManager_A01 {
    // Step 1: Declare a HashMap to store sessions
    private Map<String, String> sessionMap;

    // Step 2: Initialize the session map
    public java_33448_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Step 3: Implement the method for creating a session
    public String createSession(String userId) {
        // Step 4: Generate a unique session id for each user
        String sessionId = userId + System.currentTimeMillis();

        // Step 5: Store the session id and user id in the session map
        sessionMap.put(sessionId, userId);

        // Step 6: Return the session id
        return sessionId;
    }

    // Step 7: Implement the method for validating a session
    public String validateSession(String sessionId) {
        // Step 8: Check if the session id exists in the session map
        if(sessionMap.containsKey(sessionId)) {
            // Step 9: Return the user id associated with the session id
            return sessionMap.get(sessionId);
        } else {
            // Step 10: Return null if the session id is not valid
            return null;
        }
    }

    // Step 11: Implement the method for invalidating a session
    public void invalidateSession(String sessionId) {
        // Step 12: Remove the session id and user id from the session map
        sessionMap.remove(sessionId);
    }
}