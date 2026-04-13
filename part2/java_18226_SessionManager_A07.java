import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_18226_SessionManager_A07 {
    private SecurityManager securityManager;

    public java_18226_SessionManager_A07() {
        // Create a new SecurityManager with a privileged action
        this.securityManager = new SecurityManager() {
            @Override
            public boolean checkPermission(Permission perm) {
                return false;
            }

            @Override
            public void checkPermission(Permission perm, String msg) {
                // do nothing
            }

            @Override
            public void checkAccess(Member member) {
                // do nothing
            }

            @Override
            public void checkAccess(Member member, String operation) {
                // do nothing
            }

            @Override
            public void checkMember(Member member) {
                // do nothing
            }

            @Override
            public void checkAction(String action) {
                // do nothing
            }
        };
    }

    public void useSessionManager() {
        // Use the SecurityManager to get a session context
        securityManager.getContext(new PrivilegedAction<SessionContext>() {
            @Override
            public SessionContext run() {
                return new StandardSessionContext("session", null, null, null);
            }
        });
    }
}