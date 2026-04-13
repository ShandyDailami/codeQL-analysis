import java.util.HashMap;
import java.util.Map;

public class java_41841_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_41841_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class AuthenticationService {
    private SessionManager sessionManager;

    public java_41841_SessionManager_A07() {
        this.sessionManager = new SessionManager();
    }

    public String authenticateUser(String username, String password) {
        // Simulating a security-sensitive operation
        if (!isValidCredentials(username, password)) {
            throw new AuthFailureException("Authentication failed");
        }

        String sessionId = sessionManager.createSession(username);
        return sessionId;
    }

    private boolean isValidCredentials(String username, String password) {
        // Simulating a security-sensitive operation
        // Assume valid credentials for this example
        return true;
    }
}