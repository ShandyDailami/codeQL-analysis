import java.util.HashMap;
import java.util.Map;

public class java_27422_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_27422_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis(); // Generate a session id based on user id and current time
        sessionMap.put(sessionId, userId);
        return sessionId;
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

    public void validateSession(String sessionId) {
        if (!isValidSession(sessionId)) {
            throw new AuthFailureException("Invalid session");
        }
    }
}