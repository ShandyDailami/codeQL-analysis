import java.util.HashMap;
import java.util.Map;

public class java_38642_SessionManager_A08 {
    // HashMap to simulate session storage
    private Map<String, String> sessionMap;

    public java_38642_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to check if a session is valid
    public String validateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new SecurityException("Invalid Session ID");
        }
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new SecurityException("No Such Session ID");
        }
    }
}