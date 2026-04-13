import java.util.HashMap;
import java.util.Map;

public class java_16091_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_16091_SessionManager_A08() {
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

    public void setInvalidSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}