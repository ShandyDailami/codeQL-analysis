import java.util.HashMap;
import java.util.Map;

public class java_16468_SessionManager_A07 {
    // Using HashMap for storing session data
    private Map<String, String> sessionData;

    public java_16468_SessionManager_A07() {
        sessionData = new HashMap<>();
    }

    // Method for creating a session
    public String createSession(String userId) {
        // Generate a session id
        String sessionId = UUID.randomUUID().toString();

        // Store session data in HashMap
        sessionData.put(sessionId, userId);

        return sessionId;
    }

    // Method for retrieving a session
    public String getSession(String sessionId) {
        // Check if sessionId is valid and in the map
        if(sessionData.containsKey(sessionId)) {
            return sessionData.get(sessionId);
        } else {
            throw new AuthFailureException("Invalid Session");
        }
    }

    // Method for destroying a session
    public void destroySession(String sessionId) {
        // Remove session from the HashMap
        sessionData.remove(sessionId);
    }
}