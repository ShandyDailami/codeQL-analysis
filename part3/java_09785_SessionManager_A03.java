import java.util.HashMap;

public class java_09785_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_09785_SessionManager_A03() {
        sessionMap = new HashMap<String, String>();
    }

    public String createSession(String userId) {
        String sessionId = "" + Math.random();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}