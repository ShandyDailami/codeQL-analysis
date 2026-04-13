import java.util.HashMap;
import java.util.Map;

public class java_04522_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_04522_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        return "Session created successfully";
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public String removeSession(String sessionId) {
        sessionMap.remove(sessionId);
        return "Session removed successfully";
    }

    public String updateUserIdBySessionId(String sessionId, String newUserId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newUserId);
            return "User ID updated successfully";
        } else {
            return "No session found with the provided sessionId";
        }
    }
}