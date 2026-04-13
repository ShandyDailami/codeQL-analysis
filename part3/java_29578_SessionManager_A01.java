import java.util.HashMap;
import java.util.Map;

public class java_29578_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_29578_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean hasSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public boolean isSessionValid(String sessionId, String expectedUsername) {
        if (!hasSession(sessionId)) {
            return false;
        }

        String currentUsername = getUsername(sessionId);
        return currentUsername.equals(expectedUsername);
    }
}