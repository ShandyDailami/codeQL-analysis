import java.util.HashMap;
import java.util.Map;

public class java_26812_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_26812_SessionManager_A03() {
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
        SessionManager sm = new SessionManager();

        // Create a session
        sm.createSession("session1", "user1");

        // Get the user id associated with the session
        String userId = sm.getUserId("session1");
        System.out.println("User ID: " + userId);

        // Delete the session
        sm.deleteSession("session1");
    }
}