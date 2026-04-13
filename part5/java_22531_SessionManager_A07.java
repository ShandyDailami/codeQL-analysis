import java.util.HashMap;
import java.util.Map;

public class java_22531_SessionManager_A07 {
    // private Map to store the sessions
    private Map<String, String> sessionMap;

    // constructor
    public java_22531_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // method to create a session
    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // method to validate a session
    public String validateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    // method to delete a session
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}