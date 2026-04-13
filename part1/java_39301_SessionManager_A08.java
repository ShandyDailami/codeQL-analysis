import java.util.HashMap;
import java.util.Map;

public class java_39301_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_39301_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void checkSession(String sessionId) {
        if (sessionMap.get(sessionId) == null) {
            System.out.println("Invalid session: " + sessionId);
        }
    }
}