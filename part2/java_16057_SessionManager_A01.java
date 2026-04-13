import java.util.HashMap;
import java.util.Map;

public class java_16057_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_16057_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void deleteUser(String userId) {
        // This method is responsible for removing the sessions related to the user
        // Since we can't directly remove user from session map, we will be creating a dummy user
        // and deleting the session for that user
        // This can be a bit risky as it can affect the user sessions
        deleteSession(createSession(userId, userId));
    }

    public void deleteAllSessionsForUser(String userId) {
        // This method is responsible for removing all sessions related to a user
        // Since we can't directly remove all sessions from session map, we will be creating a dummy session
        // and deleting the sessions for that user
        // This can be a bit risky as it can affect the user sessions
        deleteSession(createSession(userId, userId));
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        String sessionId = sessionManager.createSession("123", "user1");
        System.out.println("Created session: " + sessionId);

        // Get user id from session
        String userId = sessionManager.getUserIdBySessionId("123");
        System.out.println("User id from session: " + userId);

        // Delete session
        sessionManager.deleteSession("123");

        // Delete user
        sessionManager.deleteUser("user1");

        // This will not delete user sessions as we don't have direct access to user sessions
        // sessionManager.deleteAllSessionsForUser("user1");
    }
}