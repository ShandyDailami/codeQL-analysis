import java.util.HashMap;
import java.util.Map;

public class java_07863_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_07863_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
        sessionMap.put(sessionId, userId);
    }

    public void endSession(String sessionId) {
        String userId = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        sessionMap.remove(userId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public String getUserId(String sessionId) {
        if (!isValidSession(sessionId)) {
            throw new SecurityFailureException("Invalid session: " + sessionId);
        }
        return sessionMap.get(sessionId);
    }

    public boolean isUserInSession(String userId) {
        return sessionMap.containsValue(userId);
    }
}