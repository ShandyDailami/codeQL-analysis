import java.util.HashMap;

public class java_09001_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_09001_SessionManager_A01() {
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

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public boolean isValidUser(String userId) {
        for (String sessionId : sessionMap.values()) {
            if (sessionMap.get(sessionId).equals(userId)) {
                return true;
            }
        }
        return false;
    }
}