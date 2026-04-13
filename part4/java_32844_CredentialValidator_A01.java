import java.security.Credential;
import java.security.AccessControl;
import java.security.AccessControlContext;

public class java_32844_CredentialValidator_A01 {
    private AccessControl accessControl;

    public java_32844_CredentialValidator_A01(AccessControl accessControl) {
        this.accessControl = accessControl;
    }

    public boolean isValid(Credential credential) {
        try {
            return accessControl.checkAccess(credential) == AccessControl.AccessResult.GRANTED;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a custom access control context with a mock user
        AccessControlContext context = new AccessControlContext(null, null, null, null);
        context.getSubject().getPrincipals().add(new UserPrincipal("mockUser"));

        // Create a custom credential validator and use it to check access
        CustomCredentialValidator validator = new CustomCredentialValidator(context);
        boolean isValid = validator.isValid(null);

        System.out.println("Is valid: " + isValid);
    }
}