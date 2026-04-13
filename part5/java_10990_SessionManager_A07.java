import java.util.HashMap;
import java.util.Map;

public class java_10990_SessionManager_A07 {
    private Map<String, Object> sessionMap;

    public java_10990_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        sessionMap.put(sessionId, new Object());
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public Object getSessionData(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void updateSessionData(String sessionId, Object newData) {
        sessionMap.put(sessionId, newData);
    }
}