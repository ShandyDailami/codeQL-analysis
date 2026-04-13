import java.util.HashMap;
import java.util.Map;

public class java_26447_SessionManager_A01 {

    // A map to simulate a session storage
    private Map<String, String> sessionMap;

    public java_26447_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to retrieve the userId from the session
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to end the session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to check if the session is still active
    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}