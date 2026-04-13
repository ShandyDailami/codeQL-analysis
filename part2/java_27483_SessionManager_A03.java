import java.util.HashMap;
import java.util.Map;

public class java_27483_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_27483_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        return "Session created with ID: " + sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public String endSession(String sessionId) {
        sessionMap.remove(sessionId);
        return "Session ended with ID: " + sessionId;
    }
}