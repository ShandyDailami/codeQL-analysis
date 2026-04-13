import java.util.HashMap;
import java.util.Map;

public class java_22816_SessionManager_A07 {

    // Storing session data in a HashMap
    private Map<String, String> sessionMap;

    public java_22816_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userName) {
        // Generate session id here
        // For example, we can use a UUID
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userName);
        // Store session id for future reference
    }

    public String getUserName(String sessionId) {
        // Check if sessionId is valid
        if (sessionMap.containsKey(sessionId)) {
            // Return the associated userName
            return sessionMap.get(sessionId);
        } else {
            // Handle invalid session
            return null;
        }
    }

    public void endSession(String sessionId) {
        // Remove session from map
        sessionMap.remove(sessionId);
    }
}