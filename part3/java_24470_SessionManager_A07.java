import java.util.HashMap;
import java.util.Map;

public class java_24470_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_24470_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + "_" + System.currentTimeMillis();
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

    public void authenticate(String sessionId) {
        if (!isValidSession(sessionId)) {
            throw new AuthFailureException("Invalid session");
        }

        String userId = getUserId(sessionId);

        // Authentication is sensitive, so we need to secure it
        if ("weakPassword".equals(userId)) {
            throw new AuthFailureException("Weak password");
        }

        // Authentication is successful, so we can remove the session
        removeSession(sessionId);
    }
}