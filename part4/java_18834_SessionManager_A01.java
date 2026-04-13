import java.util.HashMap;
import java.util.Map;

public class java_18834_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_18834_SessionManager_A01() {
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

    public boolean hasValidSession(String userId) {
        for (String sessionId : sessionMap.keySet()) {
            if (sessionMap.get(sessionId).equals(userId)) {
                return true;
            }
        }
        return false;
    }
}