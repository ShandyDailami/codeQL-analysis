import java.util.HashMap;
import java.util.Map;

public class java_18619_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_18619_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionId == null || userId == null) {
            throw new IllegalArgumentException("Session ID and User ID must not be null");
        }
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Session ID must not be null");
        }
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Session ID must not be null");
        }
        sessionMap.remove(sessionId);
    }

    public void destroyAllSessions() {
        sessionMap.clear();
    }

    public boolean isSessionValid(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Session ID must not be null");
        }
        return sessionMap.containsKey(sessionId);
    }

    public boolean isUserValid(String userId) {
        if (userId == null) {
            throw new IllegalArgumentException("User ID must not be null");
        }
        return !sessionMap.containsValue(userId);
    }
}