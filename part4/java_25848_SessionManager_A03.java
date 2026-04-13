import java.util.HashMap;
import java.util.Map;

public class java_25848_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_25848_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to start a new session
    public String startSession(String userId) {
        sessionMap.put("sessionId", userId);
        return sessionMap.get("sessionId");
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        if(sessionMap.containsKey("sessionId") && sessionMap.get("sessionId").equals(sessionId)) {
            return sessionMap.get("sessionId");
        } else {
            return null;
        }
    }

    // Method to end a session
    public void endSession(String sessionId) {
        sessionMap.remove("sessionId");
    }
}