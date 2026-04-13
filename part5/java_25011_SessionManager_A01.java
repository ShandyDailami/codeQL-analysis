import java.util.HashMap;
import java.util.Map;

public class java_25011_SessionManager_A01 {
    private Map<String, String> credentials;

    public java_25011_SessionManager_A01() {
        this.credentials = new HashMap<>();
    }

    public void addCredentials(String username, String password) {
        this.credentials.put(username, password);
    }

    public boolean authenticate(String username, String password) {
        return this.credentials.containsKey(username)
                && this.credentials.get(username).equals(password);
    }
}

public class SessionManager {
    private SecurityManager securityManager;
    private Map<String, String> sessionTokens;

    public java_25011_SessionManager_A01(SecurityManager securityManager) {
        this.securityManager = securityManager;
        this.sessionTokens = new HashMap<>();
    }

    public String startSession(String username, String password) {
        if (securityManager.authenticate(username, password)) {
            String token = generateSessionToken();
            this.sessionTokens.put(token, username);
            return token;
        } else {
            throw new IllegalArgumentException("Invalid username or password");
        }
    }

    public String getUsername(String token) {
        return this.sessionTokens.get(token);
    }

    private String generateSessionToken() {
        // Generate a random session token here
        return "";
    }
}