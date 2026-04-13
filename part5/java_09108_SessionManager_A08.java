import java.util.HashMap;
import java.util.Map;

public class java_09108_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_09108_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void checkSessionIntegrity() {
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            String sessionId = entry.getKey();
            String userId = entry.getValue();

            // Check if the session is still valid
            if (!isValidSession(sessionId)) {
                System.out.println("Session integrity failure detected: Session with ID " + sessionId + " is not valid anymore.");
                continue;
            }

            // Check if the user associated with the session is still valid
            if (!isValidUser(userId)) {
                System.out.println("Session integrity failure detected: User with ID " + userId + " is not valid anymore.");
                endSession(sessionId);
            }
        }
    }

    private boolean isValidUser(String userId) {
        // Add your own logic for checking user validity. For this example, we assume all user IDs are valid.
        return true;
    }
}