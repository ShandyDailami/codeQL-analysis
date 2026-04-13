import java.security.Principal;
import java.security.Permission;
import java.security.Security;
import java.util.HashSet;
import java.util.Set;

public class java_27202_SessionManager_A01 {

    // Define our permissions
    public static class CreateSessionPermission implements Permission {
        public String getActions() { return "createSession"; }
    }

    public static class DestroySessionPermission implements Permission {
        public String getActions() { return "destroySession"; }
    }

    public static class ManageSessionPermission implements Permission {
        public String getActions() { return "manageSession"; }
    }

    // Add our permissions to the security manager
    public static void installPermissions() {
        Security.addPermission(new CreateSessionPermission());
        Security.addPermission(new DestroySessionPermission());
        Security.addPermission(new ManageSessionPermission());
    }

    // Define our session class
    public static class Session {
        private String id;
        private Principal owner;

        public java_27202_SessionManager_A01(String id, Principal owner) {
            this.id = id;
            this.owner = owner;
        }

        public void destroy() {
            if (Security.getCurrentUser().equals(owner)) {
                System.out.println("Session " + id + " destroyed by " + owner);
            } else {
                throw new SecurityException("Unauthorized to destroy session");
            }
        }

        public void manage() {
            if (Security.getCurrentUser().equals(owner)) {
                System.out.println("Session " + id + " managed by " + owner);
            } else {
                throw new SecurityException("Unauthorized to manage session");
           
            }
        }
    }

    // Define our session manager
    public static class SessionManager {
        private Set<Session> sessions = new HashSet<>();

        public Session createSession(Principal owner) {
            if (Security.getCurrentUser().equals(owner) &&
                Security.getPermission(CreateSessionPermission.class).implies(Security.getPermission("ALL"))) {
                String id = Integer.toHexString(owner.hashCode());
                Session session = new Session(id, owner);
                sessions.add(session);
                return session;
            } else {
                throw new SecurityException("Unauthorized to create session");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        // Install our permissions
        installPermissions();

        // Create a session for the current user
        SessionManager sm = new SessionManager();
        sm.createSession(Security.getCurrentUser());
    }
}