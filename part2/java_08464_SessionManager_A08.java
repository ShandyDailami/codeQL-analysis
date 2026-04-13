import java.util.HashMap;

public class java_08464_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_08464_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Create session
    public String createSession(String user) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    // Get user from session
    public String getUserFromSession(String sessionId) throws SecurityFailureException {
        if (!sessionMap.containsKey(sessionId)) {
            throw new SecurityFailureException("Invalid session ID: " + sessionId);
        }
        return sessionMap.get(sessionId);
    }

    // Delete session
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

class SecurityFailureException extends Exception {
    public java_08464_SessionManager_A08(String message) {
        super(message);
    }
}