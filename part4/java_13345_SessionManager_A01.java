import java.util.HashMap;

public class java_13345_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_13345_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("Session already exists");
        } else {
            sessionMap.put(sessionId, userId);
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new RuntimeException("Session does not exist");
        }
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new RuntimeException("Session does not exist");
        }
    }
}