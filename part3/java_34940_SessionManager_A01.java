import java.util.*;

public class java_34940_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_34940_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new IllegalArgumentException("Invalid sessionId");
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new IllegalArgumentException("Invalid sessionId");
        }
    }

    public void updateUsername(String sessionId, String newUsername) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, newUsername);
        } else {
            throw new IllegalArgumentException("Invalid sessionId");
        }
    }
}