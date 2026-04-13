import java.util.HashMap;
import java.util.Map;

public class java_03591_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_03591_SessionManager_A03() {
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

        // Creating a new session
        String sessionId = "session1";
        String userId = "user1";
        sessionManager.createSession(sessionId, userId);

        // Getting the userId for the session
        String userIdInSession = sessionManager.getUserId(sessionId);
        System.out.println("UserId in session: " + userIdInSession);

        // Deleting the session
        sessionManager.deleteSession(sessionId);
    }
}