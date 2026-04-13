import java.util.HashMap;
import java.util.Map;

public class java_17365_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_17365_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        String sessionId = sessionMap.get(userId);
        if (sessionId == null) {
            throw new SecurityFailureException("Authentication failure");
        }
        return sessionId;
    }

    public void endSession(String userId) {
        sessionMap.remove(userId);
    }
}