import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import java.security.GuardianPermission;
import java.security.Permission;
import java.util.HashSet;
import java.util.Set;

public class java_36280_CredentialValidator_A01 implements CredentialValidator {

    private Set<Permission> permissions;

    public java_36280_CredentialValidator_A01() {
        permissions = new HashSet<>();
        permissions.add(new GuardianPermission("create_instance"));
    }

    @Override
    public Subject getSubject(Credential c, CallbackHandler callbackHandler) throws LoginException {
        // create subject here with custom logic
        Subject subject = new Subject.Builder().build();

        // assign permissions
        for (Permission permission : permissions) {
            subject.getPrincipals().add(permission);
        }

        return subject;
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        // return callback handler
        return new CallbackHandler() {
            @Override
            public void handle(Callback callback) throws java.io.IOException, LoginException {
                // handle callback here with custom logic
            }
        };
    }
}