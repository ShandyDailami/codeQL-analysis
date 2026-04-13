import java.util.HashMap;
import java.util.Map;

public class java_19558_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_19558_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String startSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a placeholder for a real implementation.
        // It could be a UUID, a number, or any other form of session ID.
        return "A07_AuthFailure";
    }

    public static void main(String[] args) {
        LegacySessionManager sessionManager = new LegacySessionManager();

        String sessionId = sessionManager.startSession("user1");
        System.out.println("Started session: " + sessionId);

        String userId = sessionManager.getUserId(sessionId);
        System.out.println("User ID in session: " + userId);

        sessionManager.endSession(sessionId);
    }
}