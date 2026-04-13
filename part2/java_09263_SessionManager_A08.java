import java.util.HashMap;
import java.util.Map;

public class java_09263_SessionManager_A08 {
    // A map to hold the sessions
    private Map<String, String> sessionMap;

    // A map to hold the user passwords
    private Map<String, String> userPasswordMap;

    // The constructor
    public java_09263_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
        this.userPasswordMap = new HashMap<>();
    }

    // Method to authenticate the user
    public boolean authenticateUser(String user, String password) {
        if (userPasswordMap.containsKey(user)) {
            return password.equals(userPasswordMap.get(user));
        }
        return false;
    }

    // Method to create a session for a user
    public String createSession(String user) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    // Method to validate a session
    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Method to end a session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}