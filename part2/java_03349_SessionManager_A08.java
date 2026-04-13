import java.util.HashMap;
import java.util.Map;

public class java_03349_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_03349_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Session already exists for user " + userId);
        }
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("No session found for session id " + sessionId);
        }
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("No session found for session id " + sessionId);
        }
        sessionMap.remove(sessionId);
    }

    public void validateSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("No session found for session id " + sessionId);
        }
    }
}