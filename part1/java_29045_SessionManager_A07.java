import java.util.ArrayList;
import java.util.List;

public class java_29045_SessionManager_A07 {

    private List<String> authenticatedUsers;

    public java_29045_SessionManager_A07() {
        this.authenticatedUsers = new ArrayList<>();
    }

    public void authenticate(String user) {
        // Assume this is a secure authentication method that validates user credentials
        if (authenticateUser(user)) {
            authenticatedUsers.add(user);
        } else {
            throw new AuthenticationFailureException("Authentication failed");
        }
    }

    public void authorize(String user, String operation) {
        // Assume this is a secure authorization method
        if (!authenticatedUsers.contains(user) || !authorizeOperation(operation)) {
            throw new AuthorizationFailureException("Authorization failed");
        }
    }

    // Assume these methods are secure (they use built-in security APIs)
    private boolean authenticateUser(String user) {
        // Implementation
        return true;
    }

    private boolean authorizeOperation(String operation) {
        // Implementation
        return true;
    }
}

class AuthenticationFailureException extends RuntimeException {
    public java_29045_SessionManager_A07(String message) {
        super(message);
    }
}

class AuthorizationFailureException extends RuntimeException {
    public java_29045_SessionManager_A07(String message) {
        super(message);
    }
}