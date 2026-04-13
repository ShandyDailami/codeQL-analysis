import java.util.HashMap;
import java.util.Map;

public class java_28981_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_28981_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Create a session
    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Retrieve session data
    public String getSessionData(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "Invalid Session ID";
        }
    }

    // Update session data
    public String updateSessionData(String sessionId, String newData) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newData);
            return newData;
        } else {
            return "Invalid Session ID";
        }
    }

    // Delete session
    public String deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return "Session Deleted";
        } else {
            return "Invalid Session ID";
        }
    }
}