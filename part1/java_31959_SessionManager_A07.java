import java.util.HashMap;
import java.util.Map;

public class java_31959_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_31959_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        System.out.println("Session " + sessionId + " started with user " + userId);
    }

    public void endSession(String sessionId) {
        String userId = sessionMap.get(sessionId);
        if (userId != null) {
            sessionMap.remove(sessionId);
            System.out.println("Session " + sessionId + " ended for user " + userId);
        } else {
            System.out.println("Session " + sessionId + " does not exist");
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession("A07_AuthFailure", "User1");
        sessionManager.startSession("A07_AuthFailure", "User2");
        sessionManager.endSession("A07_AuthFailure");
        sessionManager.endSession("A07_AuthFailure");
    }
}