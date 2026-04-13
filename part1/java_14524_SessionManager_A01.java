import java.util.HashMap;
import java.util.Map;

public class java_14524_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_14524_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        System.out.println("Session started with ID: " + sessionId + ", User ID: " + userId);
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended with ID: " + sessionId + ", User ID: " + userId);
        } else {
            System.out.println("Session with ID: " + sessionId + " not found.");
        }
    }

    public void validateSession(String sessionId, String expectedUserId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            if (userId.equals(expectedUserId)) {
                System.out.println("Session is validated with ID: " + sessionId + ", User ID: " + userId);
            } else {
                System.out.println("Invalid session with ID: " + sessionId + ", Expected User ID: " + expectedUserId);
            }
        } else {
            System.out.println("Session with ID: " + sessionId + " not found.");
        }
    }
}