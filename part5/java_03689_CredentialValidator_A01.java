import java.security.Credential;
import java.security.AccessControl;
import java.security.AccessControlListener;
import java.security.Guardian;
import java.util.Arrays;

public class java_03689_CredentialValidator_A01 implements CredentialValidator {
    private AccessControl accessControl;

    public java_03689_CredentialValidator_A01(AccessControl accessControl) {
        this.accessControl = accessControl;
    }

    @Override
    public boolean validate(Credential credential) {
        AccessControlListener listener = new AccessControlListener() {
            @Override
            public void accessGranted(AccessControlEvent accessControlEvent) {
                // Access granted. Continue.
            }

            @Override
            public void accessDenied(AccessControlEvent accessControlEvent) {
                // Access denied. Stop.
                throw new SecurityException("Access denied");
            }
        };

        accessControl.getGuardian().getSubject().getPrincipals().add(new Guardian() {
            @Override
            public String getName() {
                return "username";
            }
        }).add(listener);

        try {
            accessControl.check(accessControl.getGuardian().getSubject());
            return true;
        } catch (SecurityException ex) {
            // Access denied.
            return false;
        } finally {
            accessControl.getGuardian().getSubject().getPrincipals().remove(new Guardian() {
                @Override
                public String getName() {
                    return "username";
                }
            });
            accessControl.getGuardian().getSubject().remove(listener);
        }
    }
}