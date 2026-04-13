// START OF CODE

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.GuardedBy;
import java.security.Principal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_40387_CredentialValidator_A07 implements CredentialValidator {

    private static final Set<String> SUPPORTED_OPERATIONS = new HashSet<>(Arrays.asList(
            "write", "read", "delete"
    ));

    @GuardedBy("this")
    private Subject subject;

    @Override
    public Subject getSubject(CallbackHandler callbackHandler,
                              Callback[] callbacks) throws IOException,
            UnsupportedCallbackException {
        // Callback Handling for getting Subject
        subject = new Subject(true, callbackHandler, new Principal[]{new Principal("guest")});
        return subject;
    }

    @Override
    public Set<String> getSupportedOperations() {
        return SUPPORTED_OPERATIONS;
    }

    @Override
    public boolean validate(String callingPrincipal,
                           String password,
                           Set<String> roles,
                           Set<String> permissions) throws AccessControlException {
        // Verify the callingPrincipal and password
        if ("guest".equals(callingPrincipal) && "guest".equals(password)) {
            // If both are valid, set the roles and permissions
            if (roles != null) {
                subject.getPrincipals().forEach(p -> p.setUniqueName(p.getName()));
                subject.getGrantedRoles(roles.toArray(new String[0]));
            }
            if (permissions != null) {
                Set<String> supportedPermissions = getSupportedOperations();
                permissions.removeAll(supportedPermissions);
                if (!permissions.isEmpty()) {
                    throw new AccessControlException("Access is Denied");
                }
            }
            return true;
        }
        return false;
    }

}

// END OF CODE