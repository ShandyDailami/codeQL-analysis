import java.util.HashMap;
import java.util.Map;

public class java_01621_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_01621_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        // In a real-world application, this method should check if the user has a valid session and throw an exception if not.
        // For this example, we'll just simulate this by generating a unique session ID and storing it in the map.
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        // In a real-world application, this method should check if the session ID is valid and get the username associated with it,
        // and throw an exception if not.
        // For this example, we'll just return the username from the map.
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // For the sake of example, we'll generate a unique session ID here
    private String generateSessionId() {
        // This is a placeholder, replace it with actual logic for generating session ID
        return "sessionId";
    }
}