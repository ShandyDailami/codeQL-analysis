import java.util.HashMap;
import java.util.Map;

public class java_27491_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_27491_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserNameBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}