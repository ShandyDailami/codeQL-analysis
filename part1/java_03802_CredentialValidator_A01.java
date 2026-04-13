import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.AccessDeniedException;
import java.security.GuardedBy;
import java.security.Principal;
import java.security.PrivilegedAction;

public class java_03802_CredentialValidator_A01 implements CredentialValidator {

    private String expectedPassword;

    public java_03802_CredentialValidator_A01(String expectedPassword) {
        this.expectedPassword = expectedPassword;
    }

    @Override
    public AccessControlContext getAccessControlContext() {
        return new AccessControlContext();
    }

    @Override
    public boolean validate(Credential credential) {
        return validate(credential, (Principal) null);
    }

    @Override
    public boolean validate(Credential credential, Principal callingPrincipal) {
        if (callingPrincipal != null) {
            throw new UnsupportedOperationException("This operation is not supported");
        }
        return validate(credential.getIdentifier(), credential.getPassword());
    }

    public boolean validate(String user, char[] password) {
        return validate(user, new String(password));
    }

    @GuardedBy("this")
    public boolean validate(String user, String password) {
        if (password == null || password.length() == 0) {
            return false;
        }

        if (expectedPassword == null) {
            return password.toString().equals(password);
        }

        return expectedPassword.equals(password);
    }
}