import java.util.HashMap;
import java.util.Map;

public class java_39789_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_39789_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void deleteSession(String userId) {
        sessionMap.remove(userId);
    }

    public boolean isSessionValid(String userId, String sessionId) {
        return sessionMap.containsKey(userId) && sessionMap.get(userId).equals(sessionId);
    }

    public void verifySessionIntegrity(String userId, String sessionId) throws SecurityFailureException {
        if (!isSessionValid(userId, sessionId)) {
            throw new SecurityFailureException("Session integrity failure: User ID " + userId + " tried to access session with ID " + sessionId);
        }
    }
}

class SecurityFailureException extends Exception {
    public java_39789_SessionManager_A08(String message) {
        super(message);
    }
}