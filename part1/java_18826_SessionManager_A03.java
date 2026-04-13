import java.util.HashMap;
import java.util.Map;

public class java_18826_SessionManager_A03 {
    // Using a HashMap for session storage
    private Map<String, String> sessionMap;

    public java_18826_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
        return sessionId;
    }

    // Method to retrieve session data
    public String getSessionData(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to delete session
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}