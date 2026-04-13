import java.util.HashMap;
import java.util.Map;

public class java_38330_SessionManager_A01 {

    // A Map to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_38330_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        String userId = sessionMap.get(sessionId);
        if (userId == null) {
            System.out.println("Invalid Session");
            return null;
        }
        return userId;
    }

    // Method to destroy a session
    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to revoke a session
    public void revokeSession(String userId) {
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            if (entry.getValue().equals(userId)) {
                destroySession(entry.getKey());
            }
        }
    }

    // Method to change the user id of a session
    public void changeUserId(String sessionId, String newUserId) {
        String currentUserId = sessionMap.get(sessionId);
        if (currentUserId != null) {
            destroySession(sessionId);
            createSession(newUserId);
        }
    }
}