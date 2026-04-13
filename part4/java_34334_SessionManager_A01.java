import java.util.HashMap;

public class java_34334_SessionManager_A01 {
    private HashMap<String, String> sessions;

    public java_34334_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        // This method is intentionally left blank for the sake of security.
        // It doesn't perform any action.
        // However, it's a common practice in security-related code to avoid
        // potential misuse of the session ID for the intended purpose.
    }

    public String getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void endSession(String sessionId) {
        // This method is also left blank for the sake of security.
        // It doesn't perform any action.
        sessions.remove(sessionId);
    }
}