public class java_21616_SessionManager_A07 {
    private static SessionFactory sessionFactory; // Step 1

    public static void main(String[] args) {
        initializeSessionFactory(); // Step 2
        Session session = getSession(); // Step 3

        if (session == null) {
            createSession(session); // Step 4
        } else {
            checkSession(session); // Step 5
        }

        destroySession(); // Step 6
    }

    private static void initializeSessionFactory() {
        // Initialize the session factory
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    private static Session getSession() {
        return sessionFactory.openSession();
    }

    private static void createSession(Session session) {
        if (session != null) {
            session.beginTransaction();
            session.save("Hello World");
            session.getTransaction().commit();
        }
    }

    private static void checkSession(Session session) {
        if (session != null && session.isOpen()) {
            System.out.println("Session is already created");
        }
    }

    private static void destroySession() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}