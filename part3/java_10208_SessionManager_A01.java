import java.util.HashMap;
import java.util.Map;

public class java_10208_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_10208_SessionManager_A01() {
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

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}