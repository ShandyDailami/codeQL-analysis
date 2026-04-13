import java.util.HashMap;
import java.util.Map;

public class java_19264_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_19264_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        this.sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        return this.sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        this.sessionMap.remove(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return this.sessionMap.containsKey(sessionId);
    }

    public void updateSession(String sessionId, String userId) {
        this.sessionMap.replace(sessionId, userId);
    }
}