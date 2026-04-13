public class java_15011_SessionManager_A01 {
    private static SessionManager instance;
    private Session currentSession;

    private java_15011_SessionManager_A01() {
        // private constructor to restrict instantiation
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void openSession() {
        try {
            currentSession = HibernateUtil.getSessionFactory().openSession();
        } catch (HibernateException e) {
            System.out.println("Error opening session: " + e.getMessage());
        }
    }

    public void closeSession() {
        try {
            if (currentSession != null) {
                currentSession.close();
            }
        } catch (HibernateException e) {
            System.out.println("Error closing session: " + e.getMessage());
        }
    }

    public Session getCurrentSession() {
        return currentSession;
    }
}

class HibernateUtil {
    private static SessionFactory sessionFactory;

    private java_15011_SessionManager_A01() {
        // private constructor to restrict instantiation
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                // Load the Hibernate configuration
                Configuration configuration = new Configuration();
                configuration.configure("hibernate.cfg.xml");

                // Create SessionFactory
                sessionFactory = configuration.buildSessionFactory();
            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }
}