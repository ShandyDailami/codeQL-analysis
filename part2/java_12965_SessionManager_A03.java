import java.util.HashMap;
import java.util.Map;

public class java_12965_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_12965_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to validate the session
    public String validateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionId;
        } else {
            throw new SecurityException("Invalid session");
        }
    }

    // Method to end the session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}