import java.util.HashMap;
import java.util.Map;

public class java_31923_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_31923_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String username, String sessionId) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}