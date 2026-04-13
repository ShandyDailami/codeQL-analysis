import java.util.HashMap;
import java.util.Map;

public class java_20181_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_20181_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        // Generate a session key
        String sessionKey = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionKey, userId);
        return sessionKey;
    }

    public String getUserId(String sessionKey) {
        return sessionMap.get(sessionKey);
    }

    public void deleteSession(String sessionKey) {
        sessionMap.remove(sessionKey);
    }
}