import java.util.HashMap;

public class java_13441_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_13441_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null; // return null or throw an exception
        }
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}