import java.security.AccessControlException;
import java.security.AccessControlListener;
import java.security.Permission;
import java.security.SecurityPermission;
import java.util.HashMap;
import java.util.Map;

public class java_42053_SessionManager_A08 {
    private Map<String, String> sessionMap;
    private AccessControlListener accessControlListener;

    public java_42053_SessionManager_A08() {
        sessionMap = new HashMap<>();
        accessControlListener = new AccessControlListener() {
            @Override
            public void checkPermission(Permission permission) throws AccessControlException {
                if (permission instanceof SecurityPermission) {
                    throw new AccessControlException("Permission " + permission + " rejected");
                }
            }

            @Override
            public void checkActions(String actions) throws AccessControlException {
                if (!actions.equals("LOOKUP")) {
                    throw new AccessControlException("Action " + actions + " not supported");
                }
            }

            @Override
            public void handleMissingPermission(Permission permission) {
                System.out.println("Missing permission " + permission);
            }

            @Override
            public void handleMissingAction(String action) {
                System.out.println("Missing action " + action);
            }
        };
    }

    public String createSession(String user, String password) {
        String sessionId = null;
        if (password.equals("secure")) {
            sessionMap.put(user, user);
            sessionId = user;
        } else {
            throw new SecurityException("Invalid password");
        }
        return sessionId;
    }

    public String lookupSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void setAccessControlListener(AccessControlListener accessControlListener) {
        this.accessControlListener = accessControlListener;
    }
}