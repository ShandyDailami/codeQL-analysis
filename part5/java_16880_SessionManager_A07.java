import java.util.HashMap;
import java.util.Map;

public class java_16880_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_16880_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userName) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // Implementation of generating unique sessionId
        // Here for the purpose of this problem, we'll just return a simple unique string
        return "sessionId";
    }
}