import java.util.HashMap;
import java.util.Map;

public class java_04132_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_04132_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}