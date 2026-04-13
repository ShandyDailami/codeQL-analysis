import java.util.HashMap;
import java.util.Map;

public class java_07816_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_07816_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis(); // creating a random session id for now
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        String userId = "user1";
        String sessionId = sessionManager.createSession(userId);
        System.out.println("Session ID: " + sessionId);

        // Now, let's try to access the user id
        String user = sessionManager.getUserId(sessionId);
        System.out.println("User ID: " + user);

        // Delete the session
        sessionManager.deleteSession(sessionId);
    }
}