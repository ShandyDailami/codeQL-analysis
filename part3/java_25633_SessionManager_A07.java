import java.util.HashMap;
import java.util.Map;

public class java_25633_SessionManager_A07 {
    // In a real world scenario, we'd probably use a database to store sessions.
    private Map<String, String> sessionMap;

    public java_25633_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}