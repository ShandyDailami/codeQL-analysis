import java.util.HashMap;
import java.util.Map;

public class java_04567_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_04567_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String username, String sessionId) {
        sessionMap.put(sessionId, username);
    }

    public String getUsernameFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}