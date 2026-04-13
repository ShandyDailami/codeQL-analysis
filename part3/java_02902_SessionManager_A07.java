import java.util.HashMap;
import java.util.Map;

public class java_02902_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_02902_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new SecurityFailureException("Session not found or has expired");
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new SecurityFailureException("Session not found or has expired");
        }
    }
}