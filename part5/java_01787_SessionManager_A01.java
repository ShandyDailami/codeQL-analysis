import java.util.HashMap;
import java.util.Map;

public class java_01787_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_01787_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String username) {
        if (isValidUser(username)) {
            String sessionId = UUID.randomUUID().toString();
            sessionMap.put(sessionId, username);
            return sessionId;
        } else {
            throw new BrokenAccessControlException("Invalid username");
        }
    }

    public String getUserBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    private boolean isValidUser(String username) {
        // Simulate validating user in a real-world application
        // This could involve checking the username against a database, a hardcoded list, etc.
        return true;
    }
}