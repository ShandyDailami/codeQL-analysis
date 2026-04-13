import java.util.HashMap;
import java.util.Map;

public class java_41137_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_41137_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void updateSession(String oldSessionId, String newSessionId, String userId) {
        if (sessionMap.containsKey(oldSessionId)) {
            sessionMap.remove(oldSessionId);
            sessionMap.put(newSessionId, userId);
        } else {
            System.out.println("Invalid session ID");
        }
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}