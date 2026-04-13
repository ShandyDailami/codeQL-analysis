import java.util.HashMap;
import java.util.Map;

public class java_34564_SessionManager_A01 {
    private Map<String, String> credentials;

    public java_34564_SessionManager_A01() {
        credentials = new HashMap<>();
        credentials.put("admin", "password");
    }

    public String getPassword(String username) {
        return credentials.get(username);
    }
}

public class SessionManager {
    private SecurityManager securityManager;

    public java_34564_SessionManager_A01(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public String getPassword(String username) {
        return securityManager.getPassword(username);
    }

    public void startSession(String username) {
        String password = getPassword(username);
        if (password != null) {
            // Start session with the password
            System.out.println("Session started with password: " + password);
        } else {
            System.out.println("Access denied for user: " + username);
        }
    }
}