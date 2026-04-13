import java.io.Serializable;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.AccessControl;
import java.util.HashSet;

public class java_14621_SessionManager_A08 implements SecurityManager, Serializable {

    private static final long serialVersionUID = 1L;
    private HashSet<String> actions;

    public java_14621_SessionManager_A08() {
        actions = new HashSet<>();
    }

    public void addAction(String action) {
        actions.add(action);
    }

    @Override
    public boolean checkPermission(Permission perm) {
        return actions.contains(perm.getName());
    }

    @Override
    public boolean checkPermission(Permission perm, String controlFlag) throws IllegalArgumentException {
        return actions.contains(perm.getName());
    }

    @Override
    public AccessControl getAccessControl(AccessControl control) throws IllegalArgumentException {
        return control;
    }

    public static void main(String[] args) {
        MySecurityManager securityManager = new MySecurityManager();
        securityManager.addAction("create");
        securityManager.addAction("read");
        securityManager.addAction("write");
        securityManager.addAction("delete");

        SecurityManager old = System.getSecurityManager();
        System.setSecurityManager(securityManager);

        // Now we can check permissions
        System.out.println(securityManager.checkPermission(new Permission("write"))); // prints true
        System.out.println(securityManager.checkPermission(new Permission("nonexistent"))); // prints false

        System.setSecurityManager(old);
    }
}