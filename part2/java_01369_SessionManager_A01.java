import java.util.HashMap;
import java.util.Map;

public class java_01369_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_01369_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void authenticateUser(String sessionId, String expectedUsername) {
        String username = sessionMap.get(sessionId);
        if (username == null || !username.equals(expectedUsername)) {
            throw new SecurityException("Invalid session for user");
        }
    }
}