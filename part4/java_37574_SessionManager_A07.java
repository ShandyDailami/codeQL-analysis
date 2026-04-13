import java.util.HashMap;
import java.util.Map;

public class java_37574_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_37574_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void updateUserId(String oldSessionId, String newSessionId, String userId) {
        if (sessionMap.containsKey(oldSessionId)) {
            sessionMap.remove(oldSessionId);
            sessionMap.put(newSessionId, userId);
        } else {
            System.out.println("Invalid sessionId");
        }
    }
}