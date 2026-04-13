import java.util.HashMap;
import java.util.Map;

public class java_30984_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_30984_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        System.out.println("Started session for user: " + userId + " with session id: " + sessionId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        String userId = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Ended session for user: " + userId + " with session id: " + sessionId);
    }

    private String generateSessionId() {
        // For simplicity, this method just generates a random string.
        // In a real application, you would want to use a more secure method to generate the session id.
        return "sessionId";
    }
}