import java.security.AccessControlException;
import java.security.AccessControlListener;
import java.security.SecurityPermission;

public class java_40537_CredentialValidator_A03 {
    public static void main(String[] args) {
        new CredentialValidator();
    }

    private final AccessControlListener accessControlListener = new AccessControlListener() {
        public void checkPermission(AccessControlContext acctx) throws AccessControlException {
            throw new UnsupportedOperationException("Operation not supported");
        }

        public void checkActions(String actions[], AccessControlContext acctx)
                throws AccessControlException {
            throw new UnsupportedOperationException("Operation not supported");
        }

        public void refresh() throws SecurityException {
            throw new UnsupportedOperationException("Operation not supported");
        }
    };

    public java_40537_CredentialValidator_A03() {
        SecurityManager sm = System.getSecurityManager();
        if (sm == null) {
            sm = new SecurityManager();
            System.setSecurityManager(sm);
        }
        try {
            sm.checkPermission(new SecurityPermission("use class"));
            sm.checkPermission(new SecurityPermission("use class.classloader"));
            sm.checkPermission(new SecurityPermission("use classloader"));
            sm.checkPermission(new SecurityPermission("use reflection"));
            sm.checkPermission(new SecurityPermission("view classtinfo"));
            sm.checkPermission(new SecurityPermission("use transient"));
            sm.checkPermission(new SecurityPermission("use array"));
            sm.checkPermission(new SecurityPermission("use enum"));
            sm.checkPermission(new SecurityPermission("use annotation"));
        } catch (SecurityException se) {
            se.printStackTrace();
        }
    }
}