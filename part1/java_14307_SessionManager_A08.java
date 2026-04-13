import java.util.HashMap;
import java.util.Map;

public class java_14307_SessionManager_A08 {

    private static Map<String, String> sessionMap = new HashMap<>();

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new SecurityException("Session not found");
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new SecurityException("Session not found");
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionId = "session1";
        String userId = "user1";

        sessionManager.startSession(sessionId, userId);
        System.out.println("User ID from session: " + sessionManager.getUserIdFromSession(sessionId));

        sessionManager.endSession(sessionId);
        System.out.println("After end session, user ID from session: " + sessionManager.getUserIdFromSession(sessionId));
    }
}