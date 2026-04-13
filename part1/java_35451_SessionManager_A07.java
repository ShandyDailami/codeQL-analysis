import java.util.HashMap;
import java.util.Map;

public class java_35451_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_35451_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String userName) {
        String sessionId = getSessionId(userName);
        sessionMap.put(sessionId, userName);
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Implementation of A07_AuthFailure security-sensitive operations
    public boolean checkSessionExpiration(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            // Check if session has expired
            String userName = sessionMap.get(sessionId);
            // Perform check here to see if the session is expired.
            // For example, you can check if the last action was more than a certain time.
            // If so, return false.
            return false;
        } else {
            return false; // Session not found
        }
    }

    public String getSessionId(String userName) {
        // Implementation of session id generation here.
        // For example, you can use a UUID or some other method.
        // For simplicity, we'll use a simple counter.
        static int sessionCounter = 0;
        return String.valueOf(sessionCounter++);
    }
}