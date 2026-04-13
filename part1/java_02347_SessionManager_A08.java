public class java_02347_SessionManager_A08 {

    // Define a session factory
    private static org.hibernate.SessionFactory sessionFactory;

    // Define a static method to get session
    public static org.hibernate.Session getSession() {
        return sessionFactory.openSession();
    }

    // Initialize session factory
    public static void initialize() {
        try {
            sessionFactory = buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Define a session factory
    private static org.hibernate.SessionFactory buildSessionFactory() {
        // Add your own configuration here
        return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }

    // Define a class to represent an integrity failure
    public static class IntegrityFailure extends Exception {
        public java_02347_SessionManager_A08(String message) {
            super(message);
        }
    }

    // Define a method to execute a transaction
    public static void executeTransaction(Runnable task) {
        try (org.hibernate.Session session = getSession()) {
            session.beginTransaction();
            task.run();
            session.getTransaction().commit();
        } catch (IntegrityFailure e) {
            // Handle integrity failure here
            e.printStackTrace();
        } catch (Exception e) {
            // Handle general exceptions here
            e.printStackTrace();
        }
    }
}