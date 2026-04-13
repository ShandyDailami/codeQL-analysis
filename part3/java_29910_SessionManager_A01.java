import java.util.HashMap;
import java.util.Map;

public class java_29910_SessionManager_A01 {
    private Map<String, String> sessionMap;
    private Map<String, String> userMap;

    public java_29910_SessionManager_A01() {
        sessionMap = new HashMap<>();
        userMap = new HashMap<>();
    }

    public String createSession(String userId, String sessionId) {
        if (userMap.containsKey(userId)) {
            sessionMap.put(sessionId, userId);
            return "Session Created for user: " + userId;
        } else {
            return "User: " + userId + " does not exist";
        }
    }

    public String getSessionUser(String sessionId) {
        String userId = sessionMap.get(sessionId);
        if (userId != null) {
            return userId;
        } else {
            return "Invalid session: " + sessionId;
        }
    }

    public String deleteSession(String sessionId) {
        String userId = sessionMap.get(sessionId);
        if (userId != null) {
            sessionMap.remove(sessionId);
            return "Session " + sessionId + " deleted for user: " + userId;
        } else {
            return "Invalid session: " + sessionId;
        }
    }

    public String changeSessionUser(String sessionId, String newUserId) {
        String currentUserId = sessionMap.get(sessionId);
        if (currentUserId != null) {
            userMap.remove(currentUserId);
            sessionMap.remove(sessionId);
            userMap.put(newUserId, newUserId);
            sessionMap.put(sessionId, newUserId);
            return "Session " + sessionId + " changed to user: " + newUserId;
        } else {
            return "Invalid session: " + sessionId;
        }
    }
}