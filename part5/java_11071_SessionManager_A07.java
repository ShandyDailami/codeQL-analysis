import java.util.HashMap;
import java.util.Map;

public class java_11071_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_11071_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void invalidateAllSessions() {
        sessionMap.clear();
    }

    public void authenticateSession(String sessionId, String password) {
        String userId = getUserFromSession(sessionId);
        if (userId != null && userId.equals(password)) {
            System.out.println("Authentication successful for session: " + sessionId);
        } else {
            System.out.println("Authentication failed for session: " + sessionId);
            endSession(sessionId);
            throw new AuthFailureException();
        }
    }

    private class AuthFailureException extends RuntimeException {
        // This is a custom exception for authentication failure
    }
}