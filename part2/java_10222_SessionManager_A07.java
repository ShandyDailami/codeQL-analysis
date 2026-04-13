import java.util.HashMap;
import java.util.Map;

public class java_10222_SessionManager_A07 {
    // Use a HashMap to store sessions. 
    // This is a basic implementation and can be optimized for production use.
    private Map<String, String> sessionMap;

    public java_10222_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
    }

    public String getSessionUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        // For simplicity, we'll just check if the session ID exists.
        // In a real-world scenario, you'd probably want to check if the user is authenticated.
        return sessionMap.containsKey(sessionId);
    }
}