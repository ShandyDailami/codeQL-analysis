import java.util.HashMap;

public class java_21315_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_21315_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new SecurityException("Invalid session id");
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new SecurityException("Invalid session id");
        }
    }

    public void checkSessionIntegrity(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityException("Invalid session id");
        }
    }

    public void checkUserIntegrity(String userId) {
        for (String sessionId : sessionMap.keySet()) {
            if (sessionMap.get(sessionId).equals(userId)) {
                throw new SecurityException("Invalid user id");
            }
        }
    }
}