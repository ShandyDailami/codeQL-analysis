import java.util.HashMap;
import java.util.Map;

public class java_14260_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_14260_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        }
        return null;
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void updateSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, userId);
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        String sessionId = "session1";
        String userId = "user1";
        sessionManager.createSession(sessionId, userId);

        // Get the user id from the session
        String userFromSession = sessionManager.getUserIdFromSession(sessionId);
        System.out.println("User from session: " + userFromSession);

        // Update the user id in the session
        String newUserId = "user2";
        sessionManager.updateSession(sessionId, newUserId);
        String userFromSessionUpdated = sessionManager.getUserIdFromSession(sessionId);
        System.out.println("User from session after update: " + userFromSessionUpdated);

        // Delete the session
        sessionManager.deleteSession(sessionId);
    }
}