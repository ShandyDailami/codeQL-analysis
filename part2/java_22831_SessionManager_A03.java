import java.util.HashMap;

public class java_22831_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_22831_SessionManager_A03() {
        sessionMap = new HashMap<String, String>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}