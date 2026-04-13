import java.util.HashMap;
import java.util.Map;

public class java_03525_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_03525_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to start a session
    public void startSession(String userId) {
        sessionMap.put("sessionId", userId);
    }

    // Method to get the user ID from the session
    public String getUserId(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }

    // Method to end the session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to check if a session is active
    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}