import java.util.HashMap;
import java.util.Map;

public class java_34239_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_34239_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void addSession(String username, String sessionId) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}