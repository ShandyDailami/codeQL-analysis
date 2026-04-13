import java.util.HashMap;
import java.util.Map;

public class java_13732_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_13732_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if(sessionId == null || userId == null) {
            throw new IllegalArgumentException("Session ID and User ID cannot be null");
        }
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if(sessionId == null) {
            throw new IllegalArgumentException("Session ID cannot be null");
        }
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if(sessionId == null) {
            throw new IllegalArgumentException("Session ID cannot be null");
        }
        sessionMap.remove(sessionId);
    }

    public void deleteAllSessions() {
        sessionMap.clear();
    }

    public boolean isSessionExists(String sessionId) {
        if(sessionId == null) {
            throw new IllegalArgumentException("Session ID cannot be null");
        }
        return sessionMap.containsKey(sessionId);
    }

    public int getSize() {
        return sessionMap.size();
    }
}