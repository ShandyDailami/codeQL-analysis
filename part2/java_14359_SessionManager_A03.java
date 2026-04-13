public class java_14359_SessionManager_A03 {
    private static SessionManager sessionManager;
    private SessionFactory sessionFactory;

    private java_14359_SessionManager_A03(String connectionUrl) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionManager getSessionManager(String connectionUrl) {
        if (sessionManager == null) {
            sessionManager = new SessionManager(connectionUrl);
        }
        return sessionManager;
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        session.close();
    }
}