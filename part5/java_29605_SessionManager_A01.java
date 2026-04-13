import java.util.HashMap;
import java.util.Map;

public class java_29605_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_29605_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        // For security-sensitive operations, we're checking if the userId is valid and not null
        if (userId != null && !userId.isEmpty()) {
            sessionMap.put(sessionId, userId);
        } else {
            System.out.println("Invalid user ID");
        }
    }

    public void endSession(String sessionId) {
        // For security-sensitive operations, we're checking if the sessionId is valid and exists in our map
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            System.out.println("Invalid session ID");
        }
    }

    public String getUserId(String sessionId) {
        // For security-sensitive operations, we're returning the userId associated with the sessionId
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Invalid session ID");
            return null;
        }
    }
}