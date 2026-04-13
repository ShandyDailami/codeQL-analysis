import java.util.HashMap;
import java.util.Map;

public class java_10258_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_10258_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        System.out.println("Session Started: " + sessionId);
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Session Ended: " + sessionId);
        } else {
            System.out.println("No active session found with ID: " + sessionId);
        }
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}