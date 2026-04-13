import java.util.*;

public class java_17224_SessionManager_A08 {
    private Map<String, String> sessionMap;
    private List<String> activeSessions;

    public java_17224_SessionManager_A08() {
        sessionMap = new HashMap<>();
        activeSessions = new ArrayList<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        activeSessions.add(sessionId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId) && activeSessions.contains(sessionId)) {
            return sessionMap.get(sessionId);
        }
        return null;
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId) && activeSessions.contains(sessionId)) {
            activeSessions.remove(sessionId);
            sessionMap.remove(sessionId);
        }
    }
}