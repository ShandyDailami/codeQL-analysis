import java.util.HashMap;
import java.util.Map;

public class java_02298_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_02298_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userName) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    public String getUserName(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            // Access control: session not found or has expired
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            // Access control: session not found or has expired
        }
    }
}