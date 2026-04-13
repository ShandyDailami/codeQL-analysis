import java.util.HashMap;
import java.util.Map;

public class java_19870_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_19870_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = String.valueOf(sessionMap.size() + 1);
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}