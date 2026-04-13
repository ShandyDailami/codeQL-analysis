import java.util.HashMap;

public class java_04109_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_04109_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("Session already exists with id " + sessionId);
        } else {
            sessionMap.put(sessionId, userId);
        }
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new RuntimeException("Session does not exist with id " + sessionId);
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new RuntimeException("Session does not exist with id " + sessionId);
        }
    }
}