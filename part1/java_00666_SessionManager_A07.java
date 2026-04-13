import java.util.HashMap;

public class java_00666_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_00666_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Authenticate the user
        String userId = "user1";
        String sessionId = sessionManager.createSession(userId);
        System.out.println("Session ID: " + sessionId);

        // Authenticate the user again
        userId = "user2";
        sessionId = sessionManager.createSession(userId);
        System.out.println("Session ID: " + sessionId);

        // Get the user id from the session
        String user = sessionManager.getUserId(sessionId);
        System.out.println("User ID from session: " + user);

        // Remove the session
        sessionManager.removeSession(sessionId);
        System.out.println("User ID from session after removing: " + sessionManager.getUserId(sessionId));
    }
}