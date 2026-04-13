import java.util.HashMap;
import java.util.Map;

public class java_28833_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_28833_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = String.valueOf(System.nanoTime());
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void checkSessionIntegrity(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Invalid session ID: " + sessionId);
        }
    }
}