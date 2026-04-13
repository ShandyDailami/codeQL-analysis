import java.util.HashMap;
import java.util.Map;

public class java_26338_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_26338_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        // Secure sensitive operations here for A03_Injection prevention.
        // For the sake of this example, let's just generate a random session ID
        sessionMap.put("sessionId", userId);
    }

    public void endSession(String sessionId) {
        // Secure sensitive operations here for A03_Injection prevention.
        // Deleting the session can be considered a way to securely remove a session from the session map.
        sessionMap.remove(sessionId);
    }

    public String getSession(String sessionId) {
        // Secure sensitive operations here for A03_Injection prevention.
        return sessionMap.get(sessionId);
    }
}