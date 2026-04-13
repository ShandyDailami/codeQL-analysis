import java.util.HashMap;

public class java_28539_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_28539_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}