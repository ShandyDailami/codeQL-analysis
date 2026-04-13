import java.util.HashMap;

public class java_14699_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_14699_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getSession(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}