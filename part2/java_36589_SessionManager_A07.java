import java.util.HashMap;
import java.util.Map;

public class java_36589_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_36589_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Add other session management methods as needed
}