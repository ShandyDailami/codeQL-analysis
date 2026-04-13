import java.util.HashMap;
import java.util.Map;

public class java_39703_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_39703_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        sessionMap.put(sessionId, userId);
    }

    public String getSessionUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Start session
        sessionManager.startSession("user1", "session1");

        // Get session user
        String sessionUser = sessionManager.getSessionUser("session1");
        System.out.println("Session user: " + sessionUser);

        // End session
        sessionManager.endSession("session1");

        // Check if session is valid
        boolean isValidSession = sessionManager.isValidSession("session1");
        System.out.println("Is valid session: " + isValidSession);
    }
}