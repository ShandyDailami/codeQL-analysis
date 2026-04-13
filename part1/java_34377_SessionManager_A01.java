import java.util.HashMap;
import java.util.Map;

public class java_34377_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_34377_SessionManager_A01() {
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

    public boolean hasSession(String userId) {
        return sessionMap.containsKey(userId);
    }
}