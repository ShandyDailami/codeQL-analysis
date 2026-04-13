import java.util.*;

public class java_25838_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_25838_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public List<String> getAllSessions() {
        return new ArrayList<>(sessionMap.keySet());
    }
}