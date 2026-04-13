import java.util.HashMap;
import java.util.Map;

public class java_27893_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_27893_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = Integer.toString(sessionMap.size() + 1);
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean checkIntegrity(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}