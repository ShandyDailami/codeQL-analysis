import java.util.HashMap;
import java.util.Map;

public class java_05759_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_05759_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userName) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void validateSession(String sessionId) throws Exception {
        if (!sessionMap.containsKey(sessionId)) {
            throw new Exception("Invalid session ID");
        }
    }
}