import java.util.HashMap;
import java.util.Map;

public class java_41279_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_41279_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String userName) {
        String sessionId = "SESSION_" + System.currentTimeMillis();
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class AuthFailure {
    private CustomSessionManager sessionManager;

    public java_41279_SessionManager_A07() {
        this.sessionManager = new CustomSessionManager();
    }

    public String login(String username, String password) {
        // Simulate login process
        if (username.equals("admin") && password.equals("password")) {
            return sessionManager.createSession(username);
        } else {
            throw new AuthFailureException("Invalid username or password");
        }
    }

    public String getUserName(String sessionId) throws AuthFailureException {
        // Verify session and get user name
        String userName = sessionManager.getUserName(sessionId);
        if (userName == null) {
            throw new AuthFailureException("Session not found");
        }
        return userName;
    }

    public void logout(String sessionId) {
        // Delete session
        sessionManager.deleteSession(sessionId);
    }
}