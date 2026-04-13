import java.util.HashMap;
import java.util.Map;

public class java_19098_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_19098_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void deleteSession(String userId) {
        sessionMap.remove(userId);
    }

    public boolean isSessionValid(String userId, String sessionId) {
        String existingSessionId = sessionMap.get(userId);
        return existingSessionId != null && existingSessionId.equals(sessionId);
    }

    public void deleteAllSessions(String userId) {
        sessionMap.remove(userId);
    }
}