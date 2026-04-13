import javax.security.auth.Subject;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class java_21201_SessionManager_A03 {
    private List<String> authenticatedUsers;

    public java_21201_SessionManager_A03() {
        this.authenticatedUsers = new ArrayList<>();
    }

    public boolean authenticate(String user, String password) {
        // Simple password check
        if (user.equals("admin") && password.equals("password")) {
            authenticatedUsers.add(user);
            return true;
        }
        return false;
    }

    public boolean isUserAuthenticated(String user) {
        return authenticatedUsers.contains(user);
    }

    public Subject getSubject(String user, String password) {
        // You can add more complex authentication logic here
        // For now, let's just return a new Subject with an authenticated principal
        return new Subject(new Principal() {
            public String getName() {
                return user;
            }
        }, new ArrayList<>());
    }
}

public class SessionManager {
    private SecurityManager securityManager;

    public java_21201_SessionManager_A03(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public boolean login(String user, String password) {
        // Before logging in, we need to check if the user is already authenticated
        if (securityManager.isUserAuthenticated(user)) {
            return true; // User is already authenticated, we can skip authentication
        }

        // Authenticate the user
        if (securityManager.authenticate(user, password)) {
            return true;
        }

        return false;
    }

    public Subject getSubject(String user, String password) {
        // After logging in, we can use the security manager to get a subject
        return securityManager.getSubject(user, password);
    }
}