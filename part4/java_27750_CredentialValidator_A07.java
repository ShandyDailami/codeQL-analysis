import java.security.*;

public class java_27750_CredentialValidator_A07 {

    private final SecurityManager securityManager;

    public java_27750_CredentialValidator_A07() {
        this.securityManager = System.getSecurityManager();
    }

    public boolean validatePassword(String password) {
        if (securityManager != null) {
            try {
                securityManager.checkPermission(new RuntimePermission("getPassword"));
            } catch (Exception e) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        if (validator.validatePassword("strongPassword")) {
            System.out.println("Valid password");
        } else {
            System.out.println("Invalid password");
        }
    }
}