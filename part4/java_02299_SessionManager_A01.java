import java.util.HashMap;
import java.util.Map;

public class java_02299_SessionManager_A01 {
    private Map<String, String> userMap;
    private Map<String, String> roleMap;

    public java_02299_SessionManager_A01() {
        userMap = new HashMap<>();
        roleMap = new HashMap<>();
    }

    public void addUser(String user, String role) {
        userMap.put(user, role);
        roleMap.put(role, user);
    }

    public String getRole(String user) {
        return userMap.get(user);
    }

    public String getUser(String role) {
        return roleMap.get(role);
    }
}

public class SessionManager {
    private SecurityManager securityManager;

    public java_02299_SessionManager_A01(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public String getUserRole(String user) {
        return securityManager.getRole(user);
    }

    public String getUser(String role) {
        return securityManager.getUser(role);
    }
}

public class Main {
    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();
        securityManager.addUser("Alice", "admin");
        securityManager.addUser("Bob", "user");

        SessionManager sessionManager = new SessionManager(securityManager);

        String aliceRole = sessionManager.getUserRole("Alice");
        String bobUser = sessionManager.getUser("Bob");

        System.out.println("Alice's role: " + aliceRole);
        System.out.println("Bob's user: " + bobUser);
    }
}