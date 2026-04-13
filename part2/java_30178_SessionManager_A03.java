import java.util.HashMap;
import java.util.Map;

public class java_30178_SessionManager_A03 {
    private Map<String, String> credentials;

    public java_30178_SessionManager_A03() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        this.credentials.put(username, password);
    }

    public boolean authenticate(String username, String password) {
        if (this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            return true;
        }
        return false;
    }
}

public class SessionManager {
    private SecurityManager securityManager;
    private Map<String, String> sessions;

    public java_30178_SessionManager_A03(SecurityManager securityManager) {
        this.securityManager = securityManager;
        this.sessions = new HashMap<>();
    }

    public String createSession(String username) {
        if (securityManager.authenticate(username, "secure_password")) {
            String sessionId = generateSessionId();
            this.sessions.put(sessionId, username);
            return sessionId;
        } else {
            throw new SecurityException("Authentication failed");
        }
    }

    public String getUsername(String sessionId) {
        return this.sessions.get(sessionId);
    }

    private String generateSessionId() {
        // This is a placeholder for a secure session id generation,
        // but it's not recommended to use UUIDs for security reasons.
        return "sessionId";
    }
}