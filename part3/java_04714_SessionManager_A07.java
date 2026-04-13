import java.util.HashMap;
import java.util.Map;

public class java_04714_SessionManager_A07 {

    private Map<String, String> userMap;

    public java_04714_SessionManager_A07() {
        userMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        userMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return userMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        userMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return userMap.containsKey(sessionId);
    }

    public void simulateAuthFailure() {
        // Simulate an auth failure by adding a specific user to the session
        String specificUserId = "A07_AuthFailure";
        String specificSessionId = specificUserId + System.currentTimeMillis();
        userMap.put(specificSessionId, specificUserId);
    }
}