import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

public class java_05033_SessionManager_A07 {

    // This is a sample Set of users that we're using for our purpose.
    // Normally, it should come from a real user authentication system.
    private static Set<String> authorizedUsers = new HashSet<String>() {{
        add("user1");
        add("user2");
        add("user3");
    }};

    public boolean isAuthorized(Principal principal) {
        if (principal == null) {
            return false;
        }

        return authorizedUsers.contains(principal.getName());
    }

    public void performOperation(Principal principal, String operation) {
        if (!isAuthorized(principal)) {
            throw new SecurityException("Unauthorized operation: " + operation);
        }

        // Here is where you would perform the operation.
        // For simplicity, let's just print out a message.
        System.out.println("Performing operation: " + operation);
    }
}