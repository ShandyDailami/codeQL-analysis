import java.util.HashMap;
import java.util.Map;

public class java_41488_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_41488_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}