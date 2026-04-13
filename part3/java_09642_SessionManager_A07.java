import java.util.HashMap;

public class java_09642_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_09642_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = java.util.UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}