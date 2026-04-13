import java.util.HashMap;
import java.util.Map;

public class java_06803_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_06803_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        System.out.println("Session started for user: " + username + " with ID: " + sessionId);
    }

    public void endSession(String sessionId) {
        String username = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Session ended for user: " + username + " with ID: " + sessionId);
   
    }

    // Generate a unique session ID
    private String generateSessionId() {
        // Implementation depends on your specific use case.
        // For now, let's just generate a random string for simplicity
        return "A08_IntegrityFailure";
    }
}