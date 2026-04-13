import java.security.Credential;
import java.security.AccessControl;
import java.security.AccessController;
import java.security.GuardianSelector;
import java.security.GuardianSelector.UnavailableException;

public class java_14975_CredentialValidator_A01 {
    public static void main(String[] args) {
        // Instantiate a credential object.
        Credential credential = AccessController.doPrivileged(
            new CredentialAccessControl(new Credential() {
                public String getName() {
                    return "Bob";
                }
                public String getPassword() {
                    return "secret";
                }
            })
        );

        // Attempt to access a secured method.
        try {
            AccessController.doPrivileged(new SecuredAccessControl(credential));
        } catch (Exception e) {
            System.out.println("Access denied: " + e.getMessage());
        }
    }
}

class CredentialAccessControl implements PrivilegedAction {
    private final Credential credential;
    public java_14975_CredentialValidator_A01(Credential credential) {
        this.credential = credential;
    }
    public <T> T doPrivileged(PrivilegedAction<T> action) throws Exception {
        return action.execute(credential);
    }
}

class SecuredAccessControl implements PrivilegedAction<String> {
    private final Credential credential;
    public java_14975_CredentialValidator_A01(Credential credential) {
        this.credential = credential;
    }
    public String execute(String action) throws Exception {
        // Perform security-sensitive operation.
        // ...
        return action;
    }
}