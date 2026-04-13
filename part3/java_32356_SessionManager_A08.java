import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_32356_SessionManager_A08 {

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.start();
    }

    private void start() {
        SecurityManager sm = System.getSecurityManager();
        if (sm == null) {
            sm = new SecurityManager() {
                @Override
                public void checkPermission(Permission perm) {
                    throw new SecurityException("Unable to check permission: " + perm);
                }

                @Override
                public void checkActions(String actions) {
                    throw new SecurityException("Unable to check actions: " + actions);
                }
            };
            System.setSecurityManager(sm);
        }
        sm.checkPermission(new RuntimePermission("createSession"));
        sm.checkActions("createSession");
        sm.checkPermission(new RuntimePermission("getSession"));
        sm.checkActions("getSession");

        String sessionID = createSession();
        System.out.println("Session ID: " + sessionID);

        if (getSession(sessionID)) {
            System.out.println("Session found");
        } else {
            System.out.println("Session not found");
        }
    }

    private String createSession() {
        return "A08_IntegrityFailure";
    }

    private boolean getSession(String sessionID) {
        return sessionID.equals("A08_IntegrityFailure");
    }
}