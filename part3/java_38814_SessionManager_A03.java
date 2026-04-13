import java.util.HashMap;

public class java_38814_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_38814_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new IllegalArgumentException("Invalid session ID");
        }
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}