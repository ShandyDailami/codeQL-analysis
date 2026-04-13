import java.util.HashMap;
import java.util.Map;

public class java_15607_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_15607_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = String.valueOf(System.nanoTime());
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void validateUser(String sessionId, String expectedUserId) {
        if (!isValidSession(sessionId)) {
            throw new AuthFailureException("Invalid Session");
        }

        String actualUserId = getUserId(sessionId);
        if (!actualUserId.equals(expectedUserId)) {
            throw new AuthFailureException("Invalid User");
        }
    }
}