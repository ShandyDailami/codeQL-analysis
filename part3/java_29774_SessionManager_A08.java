public class java_29774_SessionManager_A08 {
    private static SessionManager sessionManager;
    private java_29774_SessionManager_A08() {}
    
    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }
    
    private Session currentSession;
    
    public Session openSession() {
        // Open a session using the standard Hibernate configuration
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        currentSession = sessionFactory.openSession();
        return currentSession;
    }
    
    public void closeSession() {
        // Close the session if it is not null
        if (currentSession != null) {
            currentSession.close();
        }
    }
}