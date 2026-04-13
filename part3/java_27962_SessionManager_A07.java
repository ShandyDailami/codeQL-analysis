import java.util.HashMap;
import java.util.Map;

public class java_27962_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_27962_SessionManager_A07() {
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

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void removeInvalidSessions() {
        sessionMap.entrySet().removeIf(entry -> !isValidSession(entry.getKey()));
    }
}