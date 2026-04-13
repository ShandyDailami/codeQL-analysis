import java.security.Permission;
import java.security.SecurityManager;

public class java_08324_SessionManager_A03 {

    private SecurityManager securityManager;
    private SessionFactory sessionFactory;

    public java_08324_SessionManager_A03(SecurityManager securityManager, SessionFactory sessionFactory) {
        this.securityManager = securityManager;
        this.sessionFactory = sessionFactory;
    }

    public Session openSession() {
        Permission permission = new SecurityPermission("session.open");
        securityManager.checkPermission(permission);
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        Permission permission = new SecurityPermission("session.close");
        securityManager.checkPermission(permission);
        session.close();
    }

    public void close() {
        Permission permission = new SecurityPermission("sessionManager.close");
        securityManager.checkPermission(permission);
        sessionFactory.close();
    }

}