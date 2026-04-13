import java.util.HashMap;
import java.util.Map;

public class java_22188_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_22188_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + "_" + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void checkSessionValidity(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            // Session is not valid
            System.out.println("Session is not valid");
        } else {
            // Session is valid
            System.out.println("Session is valid");
        }
    }
}