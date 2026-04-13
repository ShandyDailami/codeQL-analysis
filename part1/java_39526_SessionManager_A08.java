import java.util.HashMap;
import java.util.Map;

public class java_39526_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_39526_SessionManager_A08() {
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
}