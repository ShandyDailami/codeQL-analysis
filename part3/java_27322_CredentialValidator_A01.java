import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.AccessDeniedException;
import java.security.GuardedBy;
import java.security.InvalidParameterException;
import java.security.PrivilegedAction;

public class java_27322_CredentialValidator_A01 {

    private static class MyAccessControl implements AccessControl {
        @GuardedBy("this.password")
        private String password;

        public java_27322_CredentialValidator_A01(String password) {
            this.password = password;
        }

        @Override
        public boolean checkPassword(String password)
                throws AccessDeniedException {
            if (password == null || !password.equals(this.password)) {
                throw new AccessDeniedException("Invalid password");
            }
            return true;
        }
    }

    private final AccessControlContext acc;

    public java_27322_CredentialValidator_A01(String password) {
        acc = new AccessControlContext(new MyAccessControl(password));
    }

    public String validateCredentials(final String password) {
        return acc.doPrivileged(new PrivilegedAction<String>() {
            public String run() {
                try {
                    acc.checkPassword(password);
                    return "Access granted";
                } catch (AccessDeniedException e) {
                    return "Access denied";
                }
            }
        });
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("password");
        System.out.println(validator.validateCredentials("password")); // "Access granted"
        System.out.println(validator.validateCredentials("wrongpassword")); // "Access denied"
    }
}