import java.util.HashMap;
import java.util.Map;

public class java_31817_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_31817_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void checkSessionIntegrity(String sessionId) throws SecurityFailureException {
        if (!isSessionActive(sessionId)) {
            throw new SecurityFailureException("Session integrity failure: Session not active");
        }
    }

    public static class SecurityFailureException extends Exception {
        public java_31817_SessionManager_A08(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        SecuritySessionManager sessionManager = new SecuritySessionManager();

        String userId = "User1";
        String sessionId = "Session1";

        sessionManager.startSession(sessionId, userId);

        try {
            sessionManager.checkSessionIntegrity(sessionId);
            String actualUserId = sessionManager.getUserIdBySessionId(sessionId);
            if (!userId.equals(actualUserId)) {
                throw new SecurityFailureException("Session integrity failure: User ID mismatch");
            }
        } catch (SecuritySessionManager.SecurityFailureException e) {
            e.printStackTrace();
        }

        sessionManager.endSession(sessionId);
    }
}