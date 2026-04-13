import java.util.HashMap;
import java.util.Map;

public class java_34847_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_34847_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String startSession(String userName) {
        String sessionId = Integer.toString(sessionMap.size());
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    public String endSession(String sessionId) {
        String userName = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        return userName;
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}

public class AuthFailure {
    private SecurityManager securityManager;

    public java_34847_SessionManager_A07() {
        securityManager = new SecurityManager();
    }

    public String login(String userName, String password) {
        // Simulate login with hard-coded user and password
        if ("admin".equals(userName) && "password".equals(password)) {
            return securityManager.startSession(userName);
        } else {
            throw new RuntimeException("Authentication failure");
        }
    }

    public String logout(String sessionId) {
        // Validate session
        if (securityManager.isValidSession(sessionId)) {
            return securityManager.endSession(sessionId);
        } else {
            throw new RuntimeException("Invalid session");
        }
    }

    public String getUserName(String sessionId) {
        // Validate session
        if (securityManager.isValidSession(sessionId)) {
            return securityManager.getUserName(sessionId);
        } else {
            throw new RuntimeException("Invalid session");
        }
    }
}