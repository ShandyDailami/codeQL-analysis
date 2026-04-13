import java.security.Permission;
import java.security.SecurityManager;
import java.security.Guard;

public class java_41461_SessionManager_A01 implements SecurityManager {

    // This method checks if a user has the permission to access a resource
    public boolean grantPermission(Permission perm) {
        // You can implement your own logic to check permissions here
        // For example, if the perm is "view" permission, grant it
        return true;
    }

    // This method gets the name of the class that called this method
    public String getClassName() {
        return SecurityManager.class.getName();
    }

    // This method gets the method name that called this method
    public String getMethodName() {
        return "getMethodName()";
    }
}

public class SessionManager {

    private SecurityManager securityManager;

    public java_41461_SessionManager_A01(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public void startSession() {
        Guard guard = securityManager.newGuard(SessionManager.class.getName());
        guard.begin();
        guard.commit();
    }

    public void endSession() {
        Guard guard = securityManager.newGuard(SessionManager.class.getName());
        guard.begin();
        guard.abort();
    }
}