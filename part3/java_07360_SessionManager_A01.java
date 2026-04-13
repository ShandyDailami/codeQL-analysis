import java.util.HashMap;
import java.util.Map;

public class java_07360_SessionManager_A01 {

    // The session map.
    private Map<String, String> sessionMap;

    // Constructor.
    public java_07360_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    // Method to start a session.
    public String startSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to end a session.
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to get the userId for a given sessionId.
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to check if a sessionId is valid.
    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}