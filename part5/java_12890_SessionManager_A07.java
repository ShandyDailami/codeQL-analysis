import java.util.HashMap;
import java.util.Map;

public class java_12890_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_12890_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userName, String sessionId) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}