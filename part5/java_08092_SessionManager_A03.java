public class java_08092_SessionManager_A03 {
    private static SessionManager instance;
    private Session session;

    private java_08092_SessionManager_A03() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session getSession() {
        return session;
    }

    public void closeSession() {
        session.close();
    }
}

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = SessionManager.getInstance();
        sessionManager.getSession().beginTransaction();

        // Perform operations here. For example, save a user.

        sessionManager.getSession().getTransaction().commit();
        sessionManager.closeSession();
    }
}