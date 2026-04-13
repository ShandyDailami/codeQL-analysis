import java.util.HashMap;
import java.util.Map;

public class java_18221_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_18221_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        // Create a session
        String sessionId = manager.createSession("user1");

        // Get the userId associated with the session
        String userId = manager.getUserId(sessionId);
        System.out.println("User ID associated with session: " + userId);

        // Check if the session is valid
        boolean isValid = manager.isValidSession(sessionId);
        System.out.println("Is session valid? " + isValid);

        // Invalidate the session
        manager.invalidateSession(sessionId);

        // Check if the session is valid
        isValid = manager.isValidSession(sessionId);
        System.out.println("Is session valid after invalidation? " + isValid);
    }
}