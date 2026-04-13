import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_15724_CredentialValidator_A01 implements SecurityManager {

    private String allowedUsername = "admin";
    private String allowedPassword = "password";

    @Override
    public void checkPermission(Permission perm) {
        // This method is not used here, but it is required by the SecurityManager interface.
    }

    @Override
    public void checkPermission(Permission perm, Object context) {
        // This method is not used here, but it is required by the SecurityManager interface.
    }

    @Override
    public java_15724_CredentialValidator_A01(PrivilegedAction<? extends Boolean> action) {
        return action.run();
    }

    @Override
    public java_15724_CredentialValidator_A01(String className, String methodName, String signature) {
        return false;
    }

    @Override
    public java_15724_CredentialValidator_A01(String className) {
        return false;
    }

    public boolean isAccessAllowed(String username, String password) {
        return (this.allowedUsername.equals(username) && this.allowedPassword.equals(password));
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test the validator
        System.out.println(validator.isAccessAllowed("admin", "password"));  // Returns true
        System.out.println(validator.isAccessAllowed("wrongUser", "wrongPassword"));  // Returns false
    }
}