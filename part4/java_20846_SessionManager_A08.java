import java.util.HashMap;
import java.util.Map;

public class java_20846_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_20846_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("IntegrityFailure: Session already started for user: " + userId);
        }
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("IntegrityFailure: Session not started for user: " + sessionId);
        }
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("IntegrityFailure: Session not started for user: " + sessionId);
        }
        sessionMap.remove(sessionId);
    }
}