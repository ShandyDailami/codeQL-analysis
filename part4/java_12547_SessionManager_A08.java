import java.util.HashMap;
import java.util.Map;

public class java_12547_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_12547_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void checkIntegrityFailure(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("IntegrityFailure detected in session " + sessionId + ". User ID is " + sessionMap.get(sessionId));
        } else {
            System.out.println("No integrity failure detected in session " + sessionId);
        }
    }
}