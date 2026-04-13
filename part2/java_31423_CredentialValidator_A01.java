import java.security.Credential;
import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.AccessControlProvider;
import java.security.Guard;
import java.security.GuardSpi;
import java.util.HashMap;
import java.util.Map;

public class java_31423_CredentialValidator_A01 implements AccessControl {
    private final String username;
    private final char[] password;

    public java_31423_CredentialValidator_A01(String username, char[] password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate(AccessControlContext context) {
        String password = context.getPassword();
        return password != null && password.equals(this.password);
    }

    public Guard newGuard(GuardSpi spi) {
        return new Guard() {
            public boolean permitSystemAccess() {
                return true;
            }
            public boolean permitGroupAccess(String group) {
                return true;
            }
            public boolean permitOtherAccess(Object principal) {
                return validate(AccessControlContext.PRINCIPALS);
            }
        };
    }

    public static void main(String[] args) {
        User user = new User("admin", "password".toCharArray());
        AccessControl ac = new AccessControl() {
            public Guard authenticate(String type, AccessControlContext context) {
                return user.newGuard(null);
            }
        };
        if (ac.authenticate("password", AccessControlContext.PRINCIPALS).permitSystemAccess()) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }
}