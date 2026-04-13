import java.util.HashMap;
import java.util.Map;

public class java_27453_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_27453_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
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

    public void removeInvalidSessions() {
        Map<String, String> temp = new HashMap<>(sessionMap);
        sessionMap.clear();

        for (Map.Entry<String, String> entry : temp.entrySet()) {
            if (isValidSession(entry.getKey())) {
                sessionMap.put(entry.getKey(), entry.getValue());
            }
        }
    }
}