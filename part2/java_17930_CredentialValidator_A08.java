import java.security.InvalidParameterException;
import java.security.InvalidCredentialsException;
import java.security.Credential;
import java.security.AccessControl;
import java.security.AccessController;
import java.util.Iterator;
import java.util.Vector;
import java.security.PrivilegedAction;

public class java_17930_CredentialValidator_A08 {

    public static void main(String[] args) {
        try {
            AccessController.doPrivileged(new PrivilegedAction<Void>() {
                public Void run() {
                    validate("user1", "pass1");
                    validate("user2", "pass2");
                    validate("user3", "pass3");
                    return null;
                }
            });
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private static void validate(final String user, final String password) {
        if (user == null || password == null) {
            throw new InvalidParameterException("Username and password must be provided");
        }

        if (user.trim().length() == 0 || password.trim().length() == 0) {
            throw new InvalidParameterException("Username and password must be non-empty strings");
        }

        AccessControl control = new AccessControl() {
            public boolean checkPermission(Credential control) {
                return false;
            }
        };

        try {
            control.access(new PrivilegedAction<Void>() {
                public Void run() {
                    validate(user, password);
                    return null;
                }
            });
        } catch (InvalidCredentialsException ex) {
            System.out.println(user + " failed to authenticate");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}