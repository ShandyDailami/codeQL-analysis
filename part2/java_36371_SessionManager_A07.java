import java.util.HashMap;
import java.util.Map;

public class java_36371_SessionManager_A07 {
    // Step 1: Create a private static HashMap to store sessions
    private static Map<String, String> sessionMap = new HashMap<>();

    // Step 2: Create a method to create a session
    public String createSession(String userId) {
        // Step 3: Generate a unique token for the session using a UUID
        String sessionToken = UUID.randomUUID().toString();

        // Step 4: Add the session token and userId to the session map
        sessionMap.put(sessionToken, userId);

        // Step 5: Return the session token
        return sessionToken;
    }

    // Step 6: Create a method to validate a session
    public String getUserId(String sessionToken) {
        // Step 7: Check if the session token is in the session map
        if (sessionMap.containsKey(sessionToken)) {
            // Step 8: Return the userId from the session map
            return sessionMap.get(sessionToken);
        } else {
            // Step 9: If the session token is not in the map, throw a SessionNotFoundException
            throw new SessionNotFoundException("Session not found: " + sessionToken);
        }
    }

    // Step 10: Create a method to invalidate a session
    public void invalidateSession(String sessionToken) {
        // Step 11: Remove the session token from the session map
        sessionMap.remove(sessionToken);
    }

    // Step 12: Create a method to check if a session is valid
    public boolean isValidSession(String sessionToken) {
        // Step 13: Check if the session token is in the session map
        if (sessionMap.containsKey(sessionToken)) {
            // Step 14: Return true, indicating that the session is valid
            return true;
        } else {
            // Step 15: If the session token is not in the map, return false, indicating that the session is not valid
            return false;
        }
    }
}