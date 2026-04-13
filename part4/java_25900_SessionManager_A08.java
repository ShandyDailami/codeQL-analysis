import java.util.HashMap;
import java.util.Map;

public class java_25900_SessionManager_A08 {
    private Map<String, String> credentials;

    public java_25900_SessionManager_A08() {
        this.credentials = new HashMap<>();
    }

    public void addCredentials(String username, String password) {
        this.credentials.put(username, password);
    }

    public boolean isValid(String username, String password) {
        return this.credentials.get(username).equals(password);
    }
}

public class SessionManager {
    private SecurityManager securityManager;
    private Map<String, String> sessions;

    public java_25900_SessionManager_A08(SecurityManager securityManager) {
        this.securityManager = securityManager;
        this.sessions = new HashMap<>();
    }

    public String startSession(String username, String password) {
        if (this.securityManager.isValid(username, password)) {
            String sessionId = UUID.randomUUID().toString();
            this.sessions.put(sessionId, username);
            return sessionId;
        } else {
            throw new SecurityException("Invalid username or password");
        }
    }

    public String getUsername(String sessionId) {
        return this.sessions.get(sessionId);
    }

    public void endSession(String sessionId) {
        this.sessions.remove(sessionId);
    }
}