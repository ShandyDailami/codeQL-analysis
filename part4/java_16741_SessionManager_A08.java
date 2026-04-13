import java.util.HashMap;
import java.util.Map;

public class java_16741_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_16741_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        System.out.println("Started session for user " + username + " with ID " + sessionId);
    }

    public void endSession(String sessionId) {
        String username = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Ended session for user " + username + " with ID " + sessionId);
   
    }

    private String generateSessionId() {
        // This is a placeholder. In a real-world application, you would use a secure random ID generator here.
        // In this example, we're using a simple string.
        return "sessionId";
    }
}