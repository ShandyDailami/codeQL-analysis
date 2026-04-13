import java.security.Permission;
import java.security.SecurityManager;
import java.util.HashSet;
import java.util.Set;

public class java_32805_SessionManager_A08 {

    private static final Set<String> ALLOWED_ACTIONS = new HashSet<String>();
    static {
        ALLOWED_ACTIONS.add("createSession");
        ALLOWED_ACTIONS.add("endSession");
    }

    private SecurityManager securityManager;

    public java_32805_SessionManager_A08() {
        securityManager = System.getSecurityManager();
    }

    public void createSession() {
        checkPermission(new CreateSessionPermission(), "createSession");
        // create session logic here
    }

    public void endSession() {
        checkPermission(new EndSessionPermission(), "endSession");
        // end session logic here
    }

    private void checkPermission(Permission permission, String action) {
        if (securityManager == null) {
            throw new SecurityException("No security manager found");
        }

        if (!securityManager.checkPermission(permission)) {
            throw new SecurityException("Permission " + action + " denied");
        }
    }
}

class CreateSessionPermission implements Permission {
    public String getActions() {
        return ALLOWED_ACTIONS.toString();
    }
}

class EndSessionPermission implements Permission {
    public String getActions() {
        return ALLOWED_ACTIONS.toString();
    }
}