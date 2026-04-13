import java.util.HashMap;
import java.util.Map;

public class java_11979_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_11979_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void authenticate(String sessionId, String password) {
        String username = sessionMap.get(sessionId);
        if (username == null || !username.equals(password)) {
            throw new AuthenticationFailureException("Invalid username or password");
        }
    }

    public static class AuthenticationFailureException extends RuntimeException {
        public java_11979_SessionManager_A07(String message) {
            super(message);
        }
    }
}