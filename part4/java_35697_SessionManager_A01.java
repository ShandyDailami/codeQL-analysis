import java.lang.SecurityException;
import java.lang.UnsupportedOperationException;

public class java_35697_SessionManager_A01 {
    private SecurityManager securityManager;

    public java_35697_SessionManager_A01(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public void doSecurityCheck() throws SecurityException, UnsupportedOperationException {
        if (securityManager.checkPermission(this) == null) {
            throw new UnsupportedOperationException();
        }

        // Security-sensitive operations here...
    }
}