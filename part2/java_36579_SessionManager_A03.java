import java.util.HashMap;
import java.util.Map;

public class java_36579_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_36579_SessionManager_A03() {
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

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session for a user with sessionId 's1' and userId 'u1'
        sessionManager.createSession("s1", "u1");

        // Retrieve the userId for the session 's1'
        String userId = sessionManager.getUserId("s1");
        System.out.println("User ID: " + userId);

        // Delete the session 's1'
        sessionManager.deleteSession("s1");
    }
}