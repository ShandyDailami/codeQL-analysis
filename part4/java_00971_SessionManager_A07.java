import java.util.HashMap;
import java.util.Map;

public class java_00971_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_00971_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        // Generate a session key (e.g., UUID)
        String sessionKey = String.valueOf(userId.hashCode());
        sessionMap.put(sessionKey, userId);
        return sessionKey;
    }

    public String getUserId(String sessionKey) {
        // Validate session key
        if (sessionMap.containsKey(sessionKey)) {
            return sessionMap.get(sessionKey);
        } else {
            throw new IllegalArgumentException("Invalid session key");
        }
    }

    public void deleteSession(String sessionKey) {
        // Remove session from map
        sessionMap.remove(sessionKey);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String userId = "user1";
        String sessionKey = sessionManager.createSession(userId);

        // Retrieve user
        String retrievedUserId = sessionManager.getUserId(sessionKey);
        System.out.println("Retrieved user: " + retrievedUserId);

        // Deleting session
        sessionManager.deleteSession(sessionKey);
    }
}