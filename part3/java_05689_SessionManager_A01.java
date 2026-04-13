import java.util.HashMap;
import java.util.Map;

public class java_05689_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_05689_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void updateSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a new session
        String sessionId = "session1";
        String userId = "user1";
        sessionManager.createSession(sessionId, userId);

        // Get the user id from the session
        String user = sessionManager.getUserId(sessionId);
        System.out.println("User in session: " + user); // Should print "User in session: user1"

        // Update the user in the session
        user = "user2";
        sessionManager.updateSession(sessionId, user);

        // Get the updated user id from the session
        user = sessionManager.getUserId(sessionId);
        System.out.println("Updated User in session: " + user); // Should print "Updated User in session: user2"

        // Delete the session
        sessionManager.deleteSession(sessionId);
    }
}