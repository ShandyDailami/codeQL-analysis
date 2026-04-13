import java.util.HashMap;
import java.util.Map;

public class java_17292_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_17292_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        String sessionId = sessionMap.get(userId);
        if (sessionId == null) {
            throw new IllegalStateException("Insecure session access detected");
        }
        return sessionId;
    }

    public void deleteSession(String userId) {
        sessionMap.remove(userId);
    }
}