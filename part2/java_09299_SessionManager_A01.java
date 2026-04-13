public class java_09299_SessionManager_A01 {
    private static SessionManager sessionManager;
    private Session session;

    private java_09299_SessionManager_A01() {
        // Load the Hibernate library
        // Assume hibernate.jar is in classpath
        // Hibernate provides methods to load the class
        try {
            Class.forName("org.hibernate.cfg.Configuration");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public Session openSession() {
        session = HibernateUtil.getSessionFactory().openSession();
        return session;
    }

    public void closeSession() {
        session.close();
    }
}