import java.util.HashMap;
import java.util.Map;

public class java_41593_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_41593_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        String sessionId = generateSessionId(userId);
        sessionMap.put(sessionId, userId);
        System.out.println("Started session: " + sessionId);
    }

    public void endSession(String sessionId) {
        String userId = sessionMap.get(sessionId);
        if (userId != null) {
            sessionMap.remove(sessionId);
            System.out.println("Ended session: " + sessionId + " for user: " + userId);
        } else {
            System.out.println("No session found for " + sessionId);
        }
    }

    private String generateSessionId(String userId) {
        // This is a placeholder implementation, in a real-world application,
        // the session ID would be generated using a cryptographic hash function.
        // Also, this example does not include any security-related operations.
        return userId;
    }
}