import java.util.HashMap;
import java.util.Map;

public class java_35230_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_35230_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("Session Already Started");
        }

        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("Session Not Started");
        }

        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("Session Not Started");
        }

        sessionMap.remove(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}