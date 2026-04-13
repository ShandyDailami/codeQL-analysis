import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

public class java_28015_SessionManager_A07 {
    private Set<Principal> authorizedUsers;

    public java_28015_SessionManager_A07() {
        authorizedUsers = new HashSet<>();
    }

    public void addAuthorizedUser(Principal user) {
        authorizedUsers.add(user);
    }

    public void removeAuthorizedUser(Principal user) {
        authorizedUsers.remove(user);
    }

    public boolean isUserAuthorized(Principal user) {
        return authorizedUsers.contains(user);
    }

    public void handleUnauthorizedAccess(Principal user) {
        if (!isUserAuthorized(user)) {
            System.out.println("User " + user.getName() + " is unauthorized to access the system!");
            // Handle the failure by e.g., logging, throwing an exception, or redirecting to a login page
            // For the simplicity of this example, we'll just print a message and stop the execution
            System.out.println("Sorry, you are not authorized to access the system!");
            System.exit(0);
        }
    }
}