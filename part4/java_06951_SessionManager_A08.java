import java.util.HashMap;
import java.util.Map;

public class java_06951_SessionManager_A08 {
    private Map<String, String> userMap;

    public java_06951_SessionManager_A08() {
        userMap = new HashMap<>();
        userMap.put("admin", "password");
    }

    public String authenticate(String username, String password) {
        if (userMap.containsKey(username) && userMap.get(username).equals(password)) {
            return "Access granted";
        } else {
            return "Access denied";
        }
    }
}

public class SessionManager {
    private SecurityManager securityManager;

    public java_06951_SessionManager_A08(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public String authenticateUser(String username, String password) {
        return securityManager.authenticate(username, password);
    }
}