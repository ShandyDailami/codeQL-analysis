import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_25149_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_25149_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession() {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, sessionId);
        return sessionId;
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