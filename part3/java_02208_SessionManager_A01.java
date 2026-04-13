import java.util.HashMap;
import java.util.Map;

public class java_02208_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_02208_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void changeUser(String sessionId, String newUserId) {
        if (isValidSession(sessionId)) {
            String oldUserId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            sessionMap.put(sessionId, newUserId);
            // Change user in a database or in some other security-sensitive operation.
            // For simplicity, this method does not actually change the user.
            // You should replace this with the actual code for changing a user's details in a database or similar system.
        }
    }
}