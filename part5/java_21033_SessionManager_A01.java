import java.util.HashMap;
import java.util.Map;

public class java_21033_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_21033_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userName, String sessionId) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // This method checks if the session exists
    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}