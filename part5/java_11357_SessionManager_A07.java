import java.util.HashMap;
import java.util.Map;

public class java_11357_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_11357_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
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

    public void checkAuthFailure(String sessionId) {
        if (!isValidSession(sessionId)) {
            throw new SecurityException("Authentication failure. Invalid session: " + sessionId);
        }

        String userId = getUserId(sessionId);

        // This is a placeholder for actual authentication.
        // If userId is not valid, throw an exception.
        if ("A07_AuthFailure".equals(userId)) {
            throw new SecurityException("Authentication failure. User is not authorized to access: " + userId);
        }
    }
}