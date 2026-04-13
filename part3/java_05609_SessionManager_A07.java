import java.util.HashMap;
import java.util.Map;

public class java_05609_SessionManager_A07 {

    // Using a HashMap to store sessions
    private Map<String, String> sessionMap;

    // SessionManager constructor
    public java_05609_SessionManager_A07() {
        sessionMap = new HashMap<String, String>();
    }

    // Method to create a new session
    public String createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to check if a session is valid
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}