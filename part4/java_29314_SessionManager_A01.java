import java.util.HashMap;
import java.util.Map;

public class java_29314_SessionManager_A01 {
    private Map<String, String> userMap;

    public java_29314_SessionManager_A01() {
        this.userMap = new HashMap<>();
        userMap.put("user1", "ROLE_USER");
        userMap.put("user2", "ROLE_USER");
    }

    public String findUserRole(String username) {
        return userMap.get(username);
    }
}

public class SessionManager {
    private SecurityManager securityManager;

    public java_29314_SessionManager_A01(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public void openSession(String username) {
        String role = securityManager.findUserRole(username);
        if (role == null) {
            System.out.println("Access denied for user: " + username);
            return;
        }

        System.out.println("Session opened for user: " + username + ", role: " + role);
    }
}