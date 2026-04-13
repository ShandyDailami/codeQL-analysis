import java.util.HashMap;
import java.util.Map;

public class java_16788_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_16788_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void checkExpiredSessions() {
        Map<String, String> newSessionMap = new HashMap<>();
        sessionMap.entrySet().forEach(entry -> {
            if (isSessionExpired(entry.getKey())) {
                newSessionMap.put(entry.getKey(), entry.getValue());
            }
        });
        sessionMap = newSessionMap;
    }

    private boolean isSessionExpired(String sessionId) {
        // Here you can implement your session expiration logic
        // For simplicity, we just assume any session that has not started is expired
        return !isValidSession(sessionId);
    }
}