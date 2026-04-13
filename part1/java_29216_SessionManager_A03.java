import java.util.HashMap;
import java.util.Map;

public class java_29216_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_29216_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String userName) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}