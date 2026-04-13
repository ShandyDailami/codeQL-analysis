import java.util.HashMap;
import java.util.Map;

public class java_38276_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_38276_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void validateSession(String sessionId, String expectedUserId) {
        String userId = getUserId(sessionId);
        if (userId == null || !userId.equals(expectedUserId)) {
            // Handle integrity failure here
            // This is a placeholder and should be replaced with your actual code
            System.out.println("Integrity failure detected!");
        }
    }
}