import java.util.HashMap;
import java.util.Map;

public class java_15966_SessionManager_A01 {

    // Use a Map for simplicity, but a database or a proper data store would be more appropriate
    private Map<String, String> sessionMap;

    public java_15966_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userName) {
        String sessionId = "session-" + userName;
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    // Method to get the username for a session
    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to validate a session
    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}