import java.util.HashMap;
import java.util.Map;

public class java_07824_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_07824_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // create a session
        sessionManager.createSession("session1", "user1");

        // get user from session
        String userId = sessionManager.getUserId("session1");
        System.out.println("User ID: " + userId);

        // remove session
        sessionManager.removeSession("session1");
    }
}