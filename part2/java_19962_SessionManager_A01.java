import java.util.HashMap;
import java.util.Map;

public class java_19962_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_19962_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class BrokenAccessControl {
    private SessionManager sessionManager;

    public java_19962_SessionManager_A01() {
        sessionManager = new SessionManager();
    }

    public void login(String userId, String password) {
        // Simulating login operation with hardcoded password
        if (userId.equals("admin") && password.equals("password")) {
            String sessionId = "session123";
            sessionManager.createSession(userId, sessionId);
            // BrokenAccessControl: Access control
            // Access to sensitive data here
            // Access to sensitive data here
            // ...
            // Access to sensitive data here
            // Access to sensitive data here
            // ...
        } else {
            // Wrong password or user not found
        }
    }

    public void logout(String sessionId) {
        String userId = sessionManager.getUserId(sessionId);
        sessionManager.deleteSession(sessionId);
        // BrokenAccessControl: Access control
        // Access to sensitive data here
        // Access to sensitive data here
        // ...
        // Access to sensitive data here
        // Access to sensitive data here
        // ...
    }
}