import java.util.HashMap;
import java.util.Map;

public class java_08542_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_08542_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username, String sessionId) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}