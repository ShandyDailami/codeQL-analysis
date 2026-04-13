import java.util.HashMap;
import java.util.Map;

public class java_00593_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_00593_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}