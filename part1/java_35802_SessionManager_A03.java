public class java_35802_SessionManager_A03 {
    private SecurityManager securityManager;
    private SessionFactory sessionFactory;

    public java_35802_SessionManager_A03(SecurityManager securityManager, SessionFactory sessionFactory) {
        this.securityManager = securityManager;
        this.sessionFactory = sessionFactory;
    }

    public Session openSession() {
        if (securityManager.hasPermission(Thread.currentThread(), "Session.open")) {
            return sessionFactory.openSession();
        } else {
            throw new SecurityException("Permission denied to open session");
        }
    }

    public void closeSession(Session session) {
        if (securityManager.hasPermission(Thread.currentThread(), "Session.close")) {
            session.close();
        } else {
            throw new SecurityException("Permission denied to close session");
        }
    }
}