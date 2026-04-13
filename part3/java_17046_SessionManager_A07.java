import java.util.HashMap;
import java.util.Map;

public class java_17046_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_17046_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        // Generate a session ID
        String sessionId = String.valueOf(System.nanoTime());
        // Store the session ID in the map
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        // Check if the session ID is in the map
        if (sessionMap.containsKey(sessionId)) {
            // If it is, return the username associated with the session ID
            return sessionMap.get(sessionId);
        } else {
            // If it's not, throw an exception
            throw new AuthFailureException("Invalid session ID");
        }
    }

    public void deleteSession(String sessionId) {
        // Remove the session ID from the map
        sessionMap.remove(sessionId);
    }
}