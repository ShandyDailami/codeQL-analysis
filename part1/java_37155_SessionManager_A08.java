import java.util.HashMap;

public class java_37155_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_37155_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) throws Exception {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new Exception("Invalid session id");
        }
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void checkSessionIntegrity(String sessionId) throws Exception {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            // Some security-sensitive operation related to user's identity
            // For instance, check if userId matches with a stored userId
            if (!userId.equals("expectedUserId")) {
                throw new Exception("Session integrity check failed");
            }
        } else {
            throw new Exception("Invalid session id");
        }
    }
}