import java.util.HashSet;
import java.util.Set;

public class java_32141_SessionManager_A01 {
    // Define a set of allowed roles
    private Set<String> allowedRoles = new HashSet<>();

    // Constructor
    public java_32141_SessionManager_A01() {
        allowedRoles.add("ROLE_ADMIN");
        allowedRoles.add("ROLE_USER");
    }

    // Method to check if a user is authenticated and has the correct role
    public boolean isUserAllowed(String userName, String role) {
        // User is allowed if they are authenticated and have the correct role
        return isUserAuthenticated(userName) && isRoleAllowed(role);
    }

    // Simulate authentication
    private boolean isUserAuthenticated(String userName) {
        // This is a simplistic authentication process, in a real application,
        // you would likely use authentication services or a database to check if the user is authenticated
        return true;
    }

    // Method to check if a role is allowed
    private boolean isRoleAllowed(String role) {
        // Return true if the role is in the allowed roles set, otherwise false
        return allowedRoles.contains(role);
    }
}