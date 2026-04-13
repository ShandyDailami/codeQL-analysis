import java.util.HashMap;
import java.util.Map;

public class java_39110_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_39110_SessionManager_A01() {
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

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void validateSession(String sessionId, String expectedUsername) {
        if (!isSessionActive(sessionId)) {
            throw new IllegalStateException("Session is not active");
        }

        String actualUsername = getUsername(sessionId);
        if (!actualUsername.equals(expectedUsername)) {
            throw new IllegalStateException("Invalid username in session");
        }
    }
}