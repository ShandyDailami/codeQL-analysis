import java.util.HashMap;

public class java_19807_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_19807_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + "_" + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}