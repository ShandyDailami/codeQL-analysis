import java.util.HashMap;
import java.util.Map;

public class java_09698_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_09698_SessionManager_A08() {
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

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void invalidateAllSessions(String userId) {
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            if (entry.getValue().equals(userId)) {
                deleteSession(entry.getKey());
            }
        }
    }
}