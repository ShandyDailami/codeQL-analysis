import java.util.HashMap;

public class java_27752_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_27752_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = user + System.currentTimeMillis();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // TODO: Add methods for other security-sensitive operations like session expiration, concurrency control, etc.
}