import java.util.HashSet;
import java.util.Set;

public class java_05862_SessionManager_A07 {

    private Set<String> authenticatedUsers;
    private Set<String> authorizedRoles;

    public java_05862_SessionManager_A07() {
        authenticatedUsers = new HashSet<>();
        authorizedRoles = new HashSet<>();
    }

    public void login(String user, String password) {
        // This is a placeholder, the actual implementation should call a secure service
        // to authenticate the user and retrieve the roles
        if ("testuser".equals(user) && "testpassword".equals(password)) {
            authenticatedUsers.add(user);
            authorizedRoles.add("admin");
            authorizedRoles.add("user");
        }
    }

    public boolean isUserAuthenticated(String user) {
        return authenticatedUsers.contains(user);
    }

    public boolean hasRole(String role) {
        return authorizedRoles.contains(role);
    }

    public void checkAccess(String user, String role) {
        if (!isUserAuthenticated(user) || !hasRole(role)) {
            throw new SecurityException("Access Denied");
        }
    }
}

public class Main {

    public static void main(String[] args) {
        SecurityManager manager = new SecurityManager();

        manager.login("testuser", "testpassword");

        // Test access
        manager.checkAccess("testuser", "admin"); // Should not throw exception

        try {
            manager.checkAccess("invaliduser", "user"); // Should throw exception
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }

        try {
            manager.checkAccess("testuser", "invalidrole"); // Should throw exception
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }
    }
}