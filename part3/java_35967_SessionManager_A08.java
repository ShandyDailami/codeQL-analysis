import java.util.HashSet;
import java.util.Set;

public class java_35967_SessionManager_A08 {

    private Set<String> authorizedUsers = new HashSet<>();

    public java_35967_SessionManager_A08() {
        // Add some authorized users for example
        authorizedUsers.add("user1");
        authorizedUsers.add("user2");
        authorizedUsers.add("user3");
    }

    public boolean isUserAuthorized(String username) {
        return authorizedUsers.contains(username);
    }
}

public class SessionManager {

    private SecurityManager securityManager;

    public java_35967_SessionManager_A08(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public void startSession(String username) throws Exception {
        if (!securityManager.isUserAuthorized(username)) {
            throw new Exception("Unauthorized user.");
        }

        // Start session...
    }
}