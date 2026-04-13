import java.util.HashMap;
import java.util.Map;

public class java_13405_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_13405_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userName) {
        String sessionId = String.valueOf(System.currentTimeMillis());
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