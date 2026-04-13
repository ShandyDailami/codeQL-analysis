import java.security.Action;
import java.security.Permission;
import java.security.SecurityPermission;
import java.util.ArrayList;
import java.util.List;

public class java_32197_SessionManager_A08 extends SecurityManager {
    private List<String> authenticatedUsers;

    public java_32197_SessionManager_A08() {
        authenticatedUsers = new ArrayList<>();
    }

    public void addAuthenticatedUser(String username) {
        authenticatedUsers.add(username);
    }

    @Override
    public boolean checkPermission(Permission perm) {
        if (perm instanceof SecurityPermission) {
            return false;
        }
        return authenticatedUsers.contains(perm.getName());
    }

    @Override
    public boolean checkPermission(Permission perm, Object context) {
        if (perm instanceof SecurityPermission) {
            return false;
        }
        return authenticatedUsers.contains(perm.getName());
    }

    @Override
    public boolean checkActions(String actionsStr, Object context) {
        List<String> actions = new ArrayList<>();
        for (String action : actionsStr.split(",")) {
            action = action.trim();
            if (!action.isEmpty()) {
                actions.add(action);
            }
        }

        return actions.contains("A08_IntegrityFailure");
    }
}

public class Main {
    public static void main(String[] args) {
        CustomSecurityManager securityManager = new CustomSecurityManager();
        securityManager.addAuthenticatedUser("Alice");

        // Testing integrity failure
        try {
            // This should fail due to the custom SecurityManager
            System.setSecurityManager(securityManager);
            throw new Action();
        } catch (Action e) {
            System.out.println("Integrity failure detected!");
        } finally {
            System.setSecurityManager(null);
        }
    }
}