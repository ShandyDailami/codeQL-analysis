import java.util.HashMap;
import java.util.Map;

public class java_40947_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_40947_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis(); // Generate a session id based on user id and current time
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String userId = "user1";
        String sessionId = sessionManager.createSession(userId);
        System.out.println("Created session ID: " + sessionId);

        String retrievedUserId = sessionManager.getUserId(sessionId);
        System.out.println("Retrieved user ID: " + retrievedUserId);

        sessionManager.removeSession(sessionId);
        System.out.println("Removed session ID: " + sessionId);
    }
}