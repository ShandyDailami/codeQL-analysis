import java.util.HashMap;
import java.util.Map;

public class java_05229_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_05229_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        sessionMap.put(userId, userId);
    }

    public void endSession(String userId) throws SecurityFailureException {
        if (!sessionMap.containsKey(userId)) {
            throw new SecurityFailureException("Session not found");
        }

        sessionMap.remove(userId);
    }

    public static class SecurityFailureException extends Exception {
        public java_05229_SessionManager_A08(String message) {
            super(message);
        }
    }
}