import java.util.HashMap;
import java.util.Map;

public class java_19937_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_19937_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = null;
        if (!sessionMap.containsKey(userId)) {
            sessionMap.put(userId, sessionId = UUID.randomUUID().toString());
        } else {
            System.out.println("Error: User " + userId + " already has an active session!");
        }
        return sessionMap.get(userId);
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void endSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            sessionMap.remove(userId);
        } else {
            System.out.println("Error: No active session found for user " + userId);
        }
    }
}