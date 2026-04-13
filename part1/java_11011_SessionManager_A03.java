import java.util.HashMap;
import java.util.Map;

public class java_11011_SessionManager_A03 {
    // Using a HashMap for session storage
    private Map<String, String> sessionMap;

    // Constructor
    public java_11011_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method for creating a new session
    public String createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
        return sessionId;
    }

    // Method for retrieving a session
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method for removing a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}