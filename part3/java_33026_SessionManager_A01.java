import java.util.HashMap;

public class java_33026_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_33026_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean checkSessionAccess(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}