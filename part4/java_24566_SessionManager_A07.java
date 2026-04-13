public class java_24566_SessionManager_A07 {
    private static int sessionCount = 0;

    public static void main(String[] args) {
        startSession();
        startSession();
        startSession();
    }

    public static void startSession() {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            // Insert logic here

            session.getTransaction().commit();
            sessionCount++;
            System.out.println("Session " + sessionCount + " started");
        } catch (HibernateException e) {
            System.out.println("Error starting session: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}

class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.configure();

                ServiceRegistry serviceRegistry = new ServiceRegistry();
                serviceRegistry.applySettings(configuration.getProperties());

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (ExceptionInInitializerError e) {
                System.out.println("Initial SessionFactory creation failed. " + e);
            }
        }
        return sessionFactory;
    }
}