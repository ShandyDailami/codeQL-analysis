import java.util.HashMap;
import java.util.Map;

public class java_00979_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_00979_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}

public class AuthFailure {
    private SessionManager sessionManager;

    public java_00979_SessionManager_A07() {
        sessionManager = new SessionManager();
    }

    public void performAuth(String userId, String sessionId) {
        if (!sessionManager.isValidSession(sessionId)) {
            sessionManager.createSession(sessionId, userId);
            System.out.println("Session created for user: " + userId);
        } else {
            String existingUserId = sessionManager.getUserIdBySessionId(sessionId);
            if (!existingUserId.equals(userId)) {
                System.out.println("Invalid session for user: " + userId);
                sessionManager.removeSession(sessionId);
            } else {
                System.out.println("Session is valid for user: " + userId);
            }
        }
    }
}