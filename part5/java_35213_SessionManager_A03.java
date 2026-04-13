import java.util.HashMap;
import java.util.Map;

public class java_35213_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_35213_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void checkSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Invalid session: " + sessionId);
        } else {
            System.out.println("Valid session: " + sessionId);
        }
    }
}