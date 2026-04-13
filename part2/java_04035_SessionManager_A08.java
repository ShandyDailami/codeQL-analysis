import java.util.HashMap;
import java.util.Map;

public class java_04035_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_04035_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void updateSession(String sessionId, String userId) {
        sessionMap.replace(sessionId, userId);
    }

    public boolean sessionExists(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public boolean sessionUserExists(String userId) {
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            if (entry.getValue().equals(userId)) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidSession(String sessionId, String userId) {
        if (sessionExists(sessionId)) {
            String storedUserId = sessionMap.get(sessionId);
            if (storedUserId != null) {
                return storedUserId.equals(userId);
            }
        }
        return false;
    }
}