import java.util.HashMap;
import java.util.Map;

public class java_13401_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_13401_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists with id: " + sessionId);
        }

        sessionMap.put(sessionId, "SESSION_ACTIVE");
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist with id: " + sessionId);
        }

        sessionMap.remove(sessionId);
    }

    public String getSessionState(String sessionId) {
        return sessionMap.get(sessionId);
    }
}