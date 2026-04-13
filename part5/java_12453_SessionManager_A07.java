import java.util.HashMap;

public class java_12453_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_12453_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void invalidateAllSessions(String userId) {
        for (String sessionId : sessionMap.keySet()) {
            if (sessionMap.get(sessionId).equals(userId)) {
                deleteSession(sessionId);
            }
        }
    }
}