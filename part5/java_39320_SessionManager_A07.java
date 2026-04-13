import java.util.HashMap;
import java.util.Map;

public class java_39320_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_39320_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void authFailure(String sessionId) {
        if (isValidSession(sessionId)) {
            String username = sessionMap.get(sessionId);
            // Perform authentication failure operation with the username
            // ...
        } else {
            // Handle invalid session
            // ...
        }
    }
}