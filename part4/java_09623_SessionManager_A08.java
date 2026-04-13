import java.util.HashMap;
import java.util.Map;

public class java_09623_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_09623_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean integrityCheck(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId) && sessionMap.get(sessionId).equals(userId)) {
            return true;
        } else {
            return false;
        }
    }
}