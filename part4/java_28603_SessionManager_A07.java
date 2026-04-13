import java.util.HashMap;
import java.util.Map;

public class java_28603_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_28603_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userName) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Generate a unique sessionId
    private String generateSessionId() {
        // This is a dummy method, real implementation will generate a unique sessionId
        return "A07_AuthFailure_SessionID";
    }
}