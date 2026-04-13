import java.util.HashMap;
import java.util.Map;

public class java_04697_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_04697_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void endSession(String userId) {
        sessionMap.remove(userId);
    }

    public boolean isValidSession(String userId, String sessionId) {
        return sessionMap.containsKey(userId) && sessionMap.get(userId).equals(sessionId);
    }
}