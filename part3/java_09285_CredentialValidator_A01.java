import java.security.Credential;
import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.AccessDeniedException;

public class java_09285_CredentialValidator_A01 implements CredentialValidator {

    private AccessControl accessControl;

    public java_09285_CredentialValidator_A01(AccessControl accessControl) {
        this.accessControl = accessControl;
    }

    @Override
    public boolean validate(Credential credential) {
        try {
            accessControl.check(credential);
            return true;
        } catch (AccessDeniedException e) {
            return false;
        }
    }
}