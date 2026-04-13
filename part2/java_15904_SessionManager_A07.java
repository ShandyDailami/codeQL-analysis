import java.util.HashMap;
import java.util.Map;

public class java_15904_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_15904_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userName) {
        String sessionId = UUID.randomUUID().toString();
        this.sessionMap.put(sessionId, userName);
        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        if (this.sessionMap.containsKey(sessionId)) {
            return this.sessionMap.get(sessionId);
        } else {
            throw new AuthFailureException("Invalid session");
        }
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        if (this.sessionMap.containsKey(sessionId)) {
            this.sessionMap.remove(sessionId);
        } else {
            throw new AuthFailureException("Invalid session");
        }
    }
}