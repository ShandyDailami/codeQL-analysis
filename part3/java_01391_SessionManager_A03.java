import java.util.HashMap;
import java.util.Map;

public class java_01391_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_01391_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String userName) {
        if(sessionId == null || sessionId.isEmpty() || userName == null || userName.isEmpty()) {
            return "Invalid session or user details";
        }
        sessionMap.put(sessionId, userName);
        return "Session created successfully";
    }

    public String getUserFromSession(String sessionId) {
        if(sessionId == null || sessionId.isEmpty()) {
            return "Invalid session details";
        }
        return sessionMap.get(sessionId);
    }

    public String endSession(String sessionId) {
        if(sessionId == null || sessionId.isEmpty()) {
            return "Invalid session details";
        }
        sessionMap.remove(sessionId);
        return "Session ended successfully";
    }
}