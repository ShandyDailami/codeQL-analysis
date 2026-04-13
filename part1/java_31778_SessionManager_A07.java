import java.util.HashMap;
import java.util.Map;

public class java_31778_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_31778_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists. Please logout first.");
            return;
        }
        sessionMap.put(sessionId, userId);
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("No active session found. Please login first.");
            return;
        }
        sessionMap.remove(sessionId);
    }

    public String getSessionUser(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("No active session found. Please login first.");
            return null;
        }
        return sessionMap.get(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}