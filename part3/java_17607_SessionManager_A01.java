import java.util.HashMap;
import java.util.Map;

public class java_17607_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_17607_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userName) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}