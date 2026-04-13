import java.util.HashMap;
import java.util.Map;

public class java_40665_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_40665_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getSessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}