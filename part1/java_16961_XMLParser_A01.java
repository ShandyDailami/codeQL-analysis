import java.security.Permission;
import java.security.SecurityPermission;
import java.util.HashSet;
import java.util.Set;

public class java_16961_XMLParser_A01 extends SecurityManager {

    private Set<Permission> permissions = new HashSet<Permission>();

    public java_16961_XMLParser_A01() {
        Permission perm = new SecurityPermission("link.resolve");
        permissions.add(perm);
    }

    @Override
    public Set<Permission> getPermissions(ThreadGroup threadGroup) {
        return permissions;
    }

    @Override
    public Set<Permission> getPermissions(String string) {
        return permissions;
    }

    @Override
    public boolean checkPermission(Permission perm) {
        return permissions.contains(perm);
    }

    @Override
    public boolean checkPermission(String name) {
        Permission perm = new SecurityPermission(name);
        return permissions.contains(perm);
    }

    @Override
    public void refresh() {
        // No-op
    }
}

import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            SecurityManager oldSM = System.getSecurityManager();
            System.setSecurityManager(new SecurityManagerBrokenAccess());
            parse("<x>aaaaaa</x>");  // This should break, as the SecurityManagerBrokenAccess checks for a link.resolve permission
            System.setSecurityManager(oldSM);
        } catch (SecurityException se) {
            logger.severe("Caught security exception: " + se.getMessage());
        }
    }

    public static void parse(String xml) {
        // No parsing code is given, but this method is meant to be broken
    }
}