import java.util.HashMap;

public class java_00609_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_00609_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method for creating a new session
    public String createSession(String userId) {
        String sessionId = Integer.toString(sessionMap.size() + 1);
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method for destroying a session
    public boolean destroySession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return true;
        } else {
            return false;
        }
    }

    // Method for checking the validity of a session
    public boolean validateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return true;
        } else {
            return false;
        }
    }
}