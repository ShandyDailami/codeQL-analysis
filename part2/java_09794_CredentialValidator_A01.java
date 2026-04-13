import java.security.Credential;
import java.security.AccessControl;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class java_09794_CredentialValidator_A01 {

    public static void main(String[] args) {
        AccessControl acc = new AccessControl() {
            @Override
            public boolean checkAccess(Credential control) {
                return false;
            }
        };

        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            @Override
            public Void run() {
                // Access denied, no exception is thrown
                acc.checkAccess(null);
                return null;
            }
        }, acc);
    }
}