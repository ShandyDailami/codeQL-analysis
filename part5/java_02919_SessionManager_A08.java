import java.security.Action;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.ProtectionDomain;

public class java_02919_SessionManager_A08 extends SecurityManager {

    private boolean isAuthorized;

    public java_02919_SessionManager_A08(boolean isAuthorized) {
        this.isAuthorized = isAuthorized;
    }

    @Override
    public void checkPermission(Permission perm) {
        if (!isAuthorized) {
            throw new SecurityException("Permission denied");
        }
    }

    @Override
    public void checkPermission(Permission perm, ProtectionDomain domain) {
        if (!isAuthorized) {
            throw new SecurityException("Permission denied");
        }
    }

    @Override
    public void checkActions(String actionsStr, ProtectionDomain domain) {
        if (!isAuthorized) {
            throw new SecurityException("Actions denied");
        }
    }

    @Override
    public void checkPermission(PermissionCollection permColl) {
        if (!isAuthorized) {
            throw new SecurityException("Permission denied");
        }
    }

    public void setAuthorized(boolean isAuthorized) {
        this.isAuthorized = isAuthorized;
    }
}

public class TestSessionManager {

    public static void main(String[] args) {
        TestSessionManager test = new TestSessionManager();
        test.testSessionManager();
    }

    private void testSessionManager() {
        // Initialize a SecurityManager with no permissions
        CustomSecurityManager securityManager = new CustomSecurityManager(false);
        // Create a SessionFactory using the custom security manager
        SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().setSecurityManager(securityManager).buildSessionFactory();

        // Open a session using the custom security manager
        Session session = sessionFactory.openSession();

        // Here you should not see any error messages, as the session is open and the security manager allows it
        session.doWork();

        // But if you try to access a protected resource, you will get a SecurityException
        try {
            session.save("test");
        } catch (SecurityException se) {
            System.out.println(se.getMessage());
        }

        // Finally, close the session
        session.close();
    }
}