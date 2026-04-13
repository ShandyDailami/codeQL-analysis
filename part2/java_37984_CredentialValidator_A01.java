import java.security.Credential;
import java.security.AccessControl;
import java.security.AccessControlProvider;
import java.security.AccessibleOperation;

public class java_37984_CredentialValidator_A01 implements CredentialValidator {

    private AccessControl accessControl;

    public java_37984_CredentialValidator_A01() {
        try {
            accessControl = AccessControlProvider.getInstance("JavaCryptographyExtension");
        } catch (Exception ex) {
            throw new InternalError(ex.getMessage());
        }
    }

    @Override
    public boolean validate(Credential credential) {
        AccessibleOperation[] operations = accessControl.getAccessibleOperations(credential);
        for (AccessibleOperation operation : operations) {
            try {
                if (accessControl.checkAccess(credential, operation)) {
                    return true;
                }
            } catch (Exception ex) {
                throw new InternalError(ex.getMessage());
            }
        }
        return false;
    }
}