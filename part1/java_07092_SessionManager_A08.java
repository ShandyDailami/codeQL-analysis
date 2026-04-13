import java.util.HashMap;
import java.util.Map;

public class java_07092_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_07092_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void removeInvalidSession() {
        Map<String, String> tempMap = new HashMap<>(sessionMap);
        for (Map.Entry<String, String> entry : tempMap.entrySet()) {
            if (!isValidSession(entry.getKey())) {
                endSession(entry.getKey());
            }
        }
    }
}