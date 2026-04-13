import java.util.HashMap;
import java.util.Map;

public class java_03498_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_03498_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Creating a new session
        sessionManager.createSession("session1", "user1");

        // Getting the user id for a session
        String userId = sessionManager.getUserId("session1");
        System.out.println("User ID: " + userId);

        // Ending the session
        sessionManager.endSession("session1");
    }
}