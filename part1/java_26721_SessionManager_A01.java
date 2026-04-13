import java.security.Permission;
import java.security.SecurityException;

public class java_26721_SessionManager_A01 extends SecurityManager {

    @Override
    public void checkPermission(Permission perm) throws SecurityException {
        // This method is not used, but is required by the SecurityManager interface.
    }

    @Override
    public void checkPermission(Permission perm, Object context) throws SecurityException {
        // This method is not used, but is required by the SecurityManager interface.
    }

    @Override
    public void checkExit(int status) throws SecurityException {
        // This method is not used, but is required by the SecurityManager interface.
    }

    @Override
    public void checkAccess(Member member) throws SecurityException {
        // This method is not used, but is required by the SecurityManager interface.
    }

    @Override
    public void checkAccess(Member member, Object context) throws SecurityException {
        // This method is not used, but is required by the SecurityManager interface.
    }

    @Override
    public void checkMember(String name) throws SecurityException {
        // This method is not used, but is required by the SecurityManager interface.
    }

    @Override
    public void checkMember(String name, Object context) throws SecurityException {
        // This method is not used, but is required by the SecurityManager interface.
    }

    @Override
    public void checkClass(String className) throws SecurityException {
        // This method is not used, but is required by the SecurityManager interface.
    }

    @Override
    public void checkClass(String className, Object context) throws SecurityException {
        // This method is not used, but is required by the SecurityManager interface.
    }
}

public class SessionManager {

    private SimpleSecurityManager securityManager;

    public java_26721_SessionManager_A01() {
        this.securityManager = new SimpleSecurityManager();
    }

    public void startSession() {
        // This method is not used, but is required by the SessionManager interface.
    }

    public void endSession() {
        // This method is not used, but is required by the SessionManager interface.
    }
}