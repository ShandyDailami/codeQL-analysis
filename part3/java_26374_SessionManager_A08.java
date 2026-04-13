import java.util.HashMap;

public class java_26374_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_26374_SessionManager_A08() {
        sessionMap = new HashMap<String, String>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean sessionExists(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}