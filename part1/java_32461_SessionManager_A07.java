import java.util.HashMap;
import java.util.Map;

public class java_32461_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_32461_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new SecurityFailureException("Invalid session id");
        }
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}