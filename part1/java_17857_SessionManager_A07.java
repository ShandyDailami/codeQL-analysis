import java.util.HashMap;
import java.util.Map;

public class java_17857_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_17857_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public void endSession(String userId) {
        sessionMap.remove(userId);
    }

    public String getSessionId(String userId) throws SecurityFailureException {
        String sessionId = sessionMap.get(userId);
        if (sessionId == null) {
            throw new SecurityFailureException("User does not exist or has no session");
        }
        return sessionId;
    }
}

class SecurityFailureException extends Exception {
    public java_17857_SessionManager_A07(String message) {
        super(message);
    }
}