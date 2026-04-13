import java.util.HashMap;

public class java_23571_SessionManager_A07 {

    private HashMap<String, String> sessionMap;

    public java_23571_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}