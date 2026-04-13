import java.util.HashMap;
import java.util.Map;

public class java_37865_SessionManager_A07 {
    // Using a HashMap for session storage
    private Map<String, String> sessionMap;

    // Constructor
    public java_37865_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to get a user from a session
    public String getUserFromSession(String sessionId) throws AuthFailureException {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new AuthFailureException("Invalid session");
        }
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to check if a session is valid
    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}