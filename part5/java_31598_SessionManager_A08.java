import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class java_31598_SessionManager_A08 {
    // Define a map to hold session IDs and user names
    private Map<String, String> sessionMap;
    private SecureRandom sr;

    public java_31598_SessionManager_A08() {
        sessionMap = new HashMap<>();
        sr = new SecureRandom();
    }

    public String createSession(String userName) {
        // Generate a secure random session ID
        String sessionId = generateSessionId();
        // Store the session ID and user name in the map
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    public String getUserName(String sessionId) {
        // Retrieve the user name from the map
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        // Remove the session ID from the map
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // Generate a random session ID
        return String.valueOf(sr.nextInt(1000000000));
    }
}