import java.util.HashMap;
import java.util.Map;

public class java_34438_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_34438_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String userId) {
        // Add a check here to ensure the sessionId is unique
        if (sessionMap.containsKey(sessionId)) {
            return "Session ID is already in use";
        } else {
            sessionMap.put(sessionId, userId);
            return "Session created successfully";
        }
    }

    public String getUserId(String sessionId) {
        // Add a check here to ensure the sessionId is valid
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "Invalid session ID";
        }
    }

    public String deleteSession(String sessionId) {
        // Add a check here to ensure the sessionId is valid
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return "Session deleted successfully";
        } else {
            return "Invalid session ID";
        }
    }

    public String checkSessionIntegrity() {
        // Add a check here to ensure the sessionIds are valid and they're linked to a user
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            if (!entry.getValue().equals(getUserId(entry.getKey()))) {
                return "Session integrity failure found";
            }
        }
        return "All sessions are valid and linked to a user";
    }
}