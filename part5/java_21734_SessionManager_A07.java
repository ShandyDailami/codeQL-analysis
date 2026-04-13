import java.util.HashMap;
import java.util.Map;

public class java_21734_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_21734_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
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

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void validateSession(String userId, String sessionId) {
        if (!isValidSession(sessionId)) {
            throw new AuthFailureException();
        }

        String validatedSessionId = getSession(userId);

        if (!sessionId.equals(validatedSessionId)) {
            throw new AuthFailureException();
        }
    }
}

class AuthFailureException extends RuntimeException {
    public java_21734_SessionManager_A07() {
        super("Invalid Session or User");
    }
}