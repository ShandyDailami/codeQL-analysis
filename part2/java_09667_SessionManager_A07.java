import java.util.HashMap;
import java.util.Map;

public class java_09667_SessionManager_A07 {

    // SessionManager will hold the sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_09667_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userName) {
        // Generate a session ID
        String sessionId = String.valueOf(System.currentTimeMillis());

        // Store the userName and sessionId in the map
        sessionMap.put(sessionId, userName);

        // Return the sessionId
        return sessionId;
    }

    // Method to check if a session is valid
    public boolean isSessionValid(String sessionId) {
        // If the sessionId is not in the map, the session is not valid
        return sessionMap.containsKey(sessionId);
    }

    // Method to get the userName from a session
    public String getUserName(String sessionId) {
        // If the session is valid, return the userName
        return sessionMap.get(sessionId);
    }
}