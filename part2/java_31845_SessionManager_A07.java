import java.util.HashMap;
import java.util.Map;

public class java_31845_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_31845_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void authFailure(String sessionId) {
        if (isSessionValid(sessionId)) {
            deleteSession(sessionId);
        }
    }
}