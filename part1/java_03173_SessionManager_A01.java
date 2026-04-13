import java.util.HashMap;
import java.util.Map;

public class java_03173_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_03173_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void updateSession(String sessionId, String newUserId) {
        sessionMap.replace(sessionId, newUserId);
    }
}