import java.util.HashMap;
import java.util.Map;

public class java_14143_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_14143_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) throws AuthFailure {
        if (!sessionMap.containsKey(sessionId)) {
            throw new AuthFailure("Invalid session ID");
        }
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a simple example, in a real application, you would likely want to use UUIDs instead of simple strings
        return "sessionId" + System.currentTimeMillis();
    }
}