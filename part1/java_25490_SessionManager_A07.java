import java.util.HashMap;
import java.util.Map;

public class java_25490_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_25490_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}