import java.security.Credential;
import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.Permission;
import java.security.PermissionCollection;

public class java_06875_CredentialValidator_A01 implements AccessControl {

    private boolean isAdmin;

    public java_06875_CredentialValidator_A01(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public boolean checkPermission(Permission p) {
        // This method is not used here, but it's required by the AccessControl interface.
        return false;
    }

    @Override
    public PermissionCollection getPermissions(AccessControlContext acc) {
        // This method is not used here, but it's required by the AccessControl interface.
        return null;
    }

    @Override
    public boolean checkAccess(AccessControlContext acc) {
        // This method is not used here, but it's required by the AccessControl interface.
        return false;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}

public class CustomCredentialValidator implements CredentialValidator {

    private final CustomAccessControl accessControl;

    public java_06875_CredentialValidator_A01(CustomAccessControl accessControl) {
        this.accessControl = accessControl;
    }

    @Override
    public CredentialValidatorResult validate(Credential c) throws CredentialValidationException {
        if (accessControl.isAdmin()) {
            return CredentialValidatorResult.VALIDATE_SUCCESSFULLY;
        } else {
            return CredentialValidatorResult.VALIDATE_FAILED;
        }
    }
}