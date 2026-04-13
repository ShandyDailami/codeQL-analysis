import java.util.HashMap;
import java.util.Map;

public class java_11427_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_11427_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionExists(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public boolean isUserExists(String userId) {
        for(Map.Entry<String, String> entry : sessionMap.entrySet()) {
            if(entry.getValue().equals(userId)) {
                return true;
            }
        }
        return false;
    }
}