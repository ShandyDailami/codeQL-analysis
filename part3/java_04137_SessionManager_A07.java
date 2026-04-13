import java.util.HashMap;
import java.util.Map;

public class java_04137_SessionManager_A07 {
    // Step 1: Create a HashMap to store session data
    private Map<String, String> sessionData;

    // Step 2: Initialize the session data
    public java_04137_SessionManager_A07() {
        sessionData = new HashMap<>();
    }

    // Step 3: Method to create a new session
    public String createSession(String username) {
        // Step 3.1: Generate a unique session ID
        String sessionID = generateSessionID(username);

        // Step 3.2: Store the session data
        sessionData.put(sessionID, username);

        // Step 3.3: Return the session ID
        return sessionID;
    }

    // Step 4: Method to validate a session
    public String validateSession(String sessionID) {
        // Step 4.1: Check if the session ID exists in the session data
        if (sessionData.containsKey(sessionID)) {
            // Step 4.2: Return the username associated with the session ID
            return sessionData.get(sessionID);
        } else {
            // Step 4.3: Return null if the session ID does not exist
            return null;
        }
    }

    // Step 5: Method to remove a session
    public void removeSession(String sessionID) {
        // Step 5.1: Remove the session ID from the session data
        sessionData.remove(sessionID);
    }

    // Step 6: Generate a unique session ID
    private String generateSessionID(String username) {
        // Step 6.1: Combine the username and a unique ID
        return username + "_" + System.currentTimeMillis();
    }
}