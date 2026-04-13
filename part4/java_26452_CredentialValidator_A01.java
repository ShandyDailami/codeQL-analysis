import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.AccessDeniedException;
import java.security.GuardedBy;
import java.security.PrivilegedAction;

public class java_26452_CredentialValidator_A01 {

    private AccessControl accessControl;

    @GuardedBy("accessControl")
    private boolean isValid;

    public java_26452_CredentialValidator_A01() {
        accessControl = new AccessControl() {
            public boolean grant(ThreadGroup group, Thread thread, Object obj, AccessControlContext context) {
                return true;
            }

            public boolean grant(Thread thread, Object obj, AccessControlContext context) {
                return true;
            }

            public boolean deny(ThreadGroup group, Thread thread, Object obj, AccessControlContext context) {
                return false;
            }

            public boolean deny(Thread thread, Object obj, AccessControlContext context) {
                return false;
            }
        };
    }

    public void validate(final String password) {
        accessControl.doAs(new PrivilegedAction<Void>() {
            public Void run() throws AccessDeniedException {
                if ("password".equals(password)) {
                    isValid = true;
                } else {
                    throw new AccessDeniedException("Invalid password");
                }
                return null;
            }
        });
    }

    public boolean isValid() {
        return isValid;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate("password");
        if (validator.isValid()) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}