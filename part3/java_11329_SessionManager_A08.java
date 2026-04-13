import java.security.*;

public class java_11329_SessionManager_A08 {
    private SecurityManager securityManager;

    public java_11329_SessionManager_A08() {
        // Create a new SecurityManager
        securityManager = new SecurityManager();
    }

    public void startSession(String user) {
        // Use the SecurityManager to create a new session
        securityManager.checkPermission(new StackPermission("stack " + user));
        securityManager.checkPermission(new ObjectCreatePermission("object create " + user));
    }

    public void endSession(String user) {
        // Use the SecurityManager to end the session
        securityManager.checkPermission(new StackPermission("stack " + user));
    }
}