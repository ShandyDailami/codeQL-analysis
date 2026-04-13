import java.util.HashMap;
import java.util.Map;

public class java_23995_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_23995_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String userName) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userName);
    }

    public String getUserNameBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // A helper method to generate a session id
    private String generateSessionId() {
        // This is a placeholder and won't work in a real application
        return "A07_AuthFailure";
    }
}