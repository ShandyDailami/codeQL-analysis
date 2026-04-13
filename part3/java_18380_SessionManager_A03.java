import java.util.HashMap;

public class java_18380_SessionManager_A03 {

    private HashMap<String, String> sessionMap;

    public java_18380_SessionManager_A03() {
        sessionMap = new HashMap<String, String>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void updateSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, userId);
        }
    }
}