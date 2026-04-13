import java.util.HashMap;
import java.util.Map;

public class java_03911_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_03911_SessionManager_A08() {
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

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}