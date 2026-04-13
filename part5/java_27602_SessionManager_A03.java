import java.util.*;

public class java_27602_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_27602_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session is already started.");
        }

        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session is not started.");
        }

        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session is not started.");
        }

        sessionMap.remove(sessionId);
    }
}