import java.util.HashMap;
import java.util.Map;

public class java_00875_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_00875_SessionManager_A01() {
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

    public void deleteAllSessions(String userId) {
        Map<String, String> tempMap = new HashMap<>(sessionMap);
        for (Map.Entry<String, String> entry : tempMap.entrySet()) {
            if (entry.getValue().equals(userId)) {
                sessionMap.remove(entry.getKey());
            }
        }
    }
}