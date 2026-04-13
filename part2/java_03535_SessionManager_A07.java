import java.util.HashMap;
import java.util.Map;

public class java_03535_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_03535_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis(); // Generate a session ID based on user ID and current time in milliseconds
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void validateSession(String sessionId) throws AuthFailure {
        if (!sessionMap.containsKey(sessionId)) {
            throw new AuthFailure("Invalid session");
        }
    }
}