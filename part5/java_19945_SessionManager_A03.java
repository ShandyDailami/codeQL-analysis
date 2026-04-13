import java.security.Action;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_19945_SessionManager_A03 {

    private SecurityManager securityManager;

    public java_19945_SessionManager_A03(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public void startSession() {
        securityManager.permitActions(new Action[] {
            new PrivilegedAction<Void>() {
                public Void run() {
                    System.out.println("Starting session...");
                    // Perform session-related operations here
                    return null;
                }
            }
        });
    }

    public void endSession() {
        securityManager.permitActions(new Action[] {
            new PrivilegedAction<Void>() {
                public Void run() {
                    System.out.println("Ending session...");
                    // Perform clean-up operations here
                    return null;
                }
            }
        });
    }
}