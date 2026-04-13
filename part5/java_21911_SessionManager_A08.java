public class java_21911_SessionManager_A08 {
    private static int sessionCount = 0;

    private java_21911_SessionManager_A08() {
        // Private constructor to prevent instantiation of the class
    }

    public static Session openSession() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
        sessionCount++;
        return session;
    }

    public static void closeSession(Session session) {
        if (session != null && session.getTransaction().isActive()) {
            session.getTransaction().commit();
            sessionCount--;
        }
    }

    public static int getSessionCount() {
        return sessionCount;
    }
}

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

public class Main {
    public static void main(String[] args) {
        Session session1 = SessionManager.openSession();
        Session session2 = SessionManager.openSession();

        // Do some integrity-related operations here...

        SessionManager.closeSession(session1);
        SessionManager.closeSession(session2);

        System.out.println("Number of active sessions: " + SessionManager.getSessionCount());
    }
}