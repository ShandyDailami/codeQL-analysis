import java.util.HashMap;
import java.util.Map;

public class java_09661_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_09661_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public boolean isUserAuthorized(String sessionId) {
        String userId = getUserId(sessionId);
        if (userId == null) {
            return false;
        }
        // Here you can add more secure operations related to authentication failure
        // For example, you can check if the user's account is enabled and if the account is locked
        // This is a placeholder and should be replaced with your actual logic
        return true;
    }
}