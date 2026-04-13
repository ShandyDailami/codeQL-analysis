import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.AuthenticationException;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_37190_SessionManager_A01 implements Subject {
    private Set<String> roles = new HashSet<>(Arrays.asList("ROLE_USER", "ROLE_ADMIN"));
    private Set<String> attributes = new HashSet<>(Arrays.asList("read"));

    public Set<String> getRoles(String password) throws AccessControlException {
        return roles;
    }

    public Set<String> getAvailableAttributes() throws AccessControlException {
        return attributes;
    }

    public void setCallbackHandler(CallbackHandler callbackHandler) {
        // Not required for this example
    }

    public void validate(Subject subject, Callback[] callbacks) throws AuthenticationException, AccessControlException {
        // Not required for this example
    }

    public boolean hasRole(String role) throws AccessControlException {
        return role != null && role.equals("ROLE_ADMIN");
    }

    public boolean setWriteCallback(Callback[] callbacks) throws UnsupportedCallbackException {
        return false;
    }

    public boolean supports(String option) {
        return false;
    }

    public void removeRole(String role) throws AccessControlException {
        if (role != null && role.equals("ROLE_ADMIN")) {
            throw new AccessControlException("Cannot remove ROLE_ADMIN");
        }
    }

    public void addRole(String role) throws AccessControlException {
        if (role != null && role.equals("ROLE_ADMIN")) {
            throw new AccessControlException("Cannot add ROLE_ADMIN");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Subject subject = new CustomSecurityManager();
            // The program will now raise an AccessControlException when it tries to set a role
            subject.addRole("ROLE_USER");
            subject.removeRole("ROLE_ADMIN");
            // The program will now raise an AccessControlException when it tries to get a role
            subject.getRoles("invalid_password");
            // The program will now raise an AccessControlException when it tries to get available attributes
            subject.getAvailableAttributes();
        } catch (AccessControlException e) {
            System.out.println("Access Denied: " + e.getMessage());
        }
    }
}