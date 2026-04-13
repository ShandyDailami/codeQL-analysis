import java.util.HashMap;
import java.util.Map;

public class java_37049_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_37049_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String startSession() {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public String getNextSessionId() {
        return sessionMap.keySet().iterator().next();
    }
}