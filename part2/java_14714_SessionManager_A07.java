import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.Guard;
import java.security.Permission;
import java.security.Policy;
import java.util.Set;

public class java_14714_SessionManager_A07 {

    // Define the Access Control
    private static final AccessControlContext context = new AccessControlContext();
    private static final Guard guard = new Guard() {
        public boolean grant(Permission permission) {
            return false;
        }
    };
    private static final Policy policy = new Policy() {
        public Set<Permission> getPermissions(AccessControl context) {
            return null;
        }
    };
    private static final AccessControl accessControl = new AccessControl() {
        public Guard getGuard(AccessControlContext context) {
            return guard;
        }
        public Policy getPolicy() {
            return policy;
        }
    };

    // Create Session
    public Session createSession(String user) {
        // Use the Access Control to verify the user's permissions
        if (accessControl.getGuard(context). permit(user)) {
            return new Session(user);
        } else {
            throw new SecurityFailureException("Unauthorized access to session creation");
        }
    }

    // Inner class for Session
    public class Session {
        private String user;

        public java_14714_SessionManager_A07(String user) {
            this.user = user;
        }

        public String getUser() {
            return user;
        }

        public void closeSession() {
            // Closing session
        }
    }
}