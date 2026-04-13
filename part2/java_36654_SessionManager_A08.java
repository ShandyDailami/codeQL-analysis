import java.util.HashMap;

public class java_36654_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_36654_SessionManager_A08() {
        sessionMap = new HashMap<>();
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

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void updateSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, userId);
        }
    }
}