import java.util.HashMap;
import java.util.Map;

public class java_26419_SessionManager_A07 {
    private Map<String, String> sessionData;

    public java_26419_SessionManager_A07() {
        this.sessionData = new HashMap<>();
    }

    public void startSession(String userId) {
        sessionData.put("userId", userId);
    }

    public String getSessionUserId(String sessionId) {
        return sessionData.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionData.remove(sessionId);
    }

    // Add more methods if necessary, e.g., to check if a session is valid
}