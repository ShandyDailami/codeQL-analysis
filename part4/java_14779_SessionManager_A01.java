import java.util.HashMap;
import java.util.Map;

public class java_14779_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_14779_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        // For the sake of this example, let's assume a valid username
        if (!isUsernameValid(username)) {
            throw new RuntimeException("Invalid username: " + username);
        }

        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    private String generateSessionId() {
        // For the sake of this example, let's assume a random session id
        return "session" + System.currentTimeMillis();
    }

    private boolean isUsernameValid(String username) {
        // For the sake of this example, let's assume a valid username
        return true;
    }
}