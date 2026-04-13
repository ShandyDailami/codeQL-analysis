import java.util.HashMap;
import java.util.Map;

public class java_38606_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_38606_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = user + System.currentTimeMillis();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class BrokenAccessControl {
    private SessionManager sessionManager;

    public java_38606_SessionManager_A01() {
        sessionManager = new SessionManager();
    }

    public void login(String username, String password) {
        // This method should not be directly called.
        // Instead, it should be called through a secure interface.
        // In this example, we'll just print out a message to the console.
        System.out.println("Login attempt with username: " + username);
    }

    public void startSession(String username) {
        String sessionId = sessionManager.createSession(username);
        System.out.println("Created session for user: " + username + ". Session ID: " + sessionId);
    }

    public void endSession(String sessionId) {
        String username = sessionManager.getUser(sessionId);
        sessionManager.deleteSession(sessionId);
        System.out.println("Ended session for user: " + username + ". Session ID: " + sessionId);
    }
}