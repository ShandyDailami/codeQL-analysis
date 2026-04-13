import java.util.HashMap;
import java.util.Map;

public class java_20505_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_20505_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void handleAuthFailure(String sessionId) {
        if (isSessionValid(sessionId)) {
            String userId = getUserIdBySessionId(sessionId);
            // perform security sensitive operation related to userId
            System.out.println("Security sensitive operation for user: " + userId);
        } else {
            System.out.println("Invalid session: " + sessionId);
        }
    }
}