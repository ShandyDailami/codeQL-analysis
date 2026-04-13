public class java_27567_SessionManager_A07 {
    // Static session variable
    private static Session session;

    // Method to create a session
    public static void createSession() {
        try {
            // Create a session factory
            SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory();

            // Create a new session
            session = sessionFactory.openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to close a session
    public static void closeSession() {
        if (session != null) {
            session.close();
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        createSession();
        closeSession();
    }
}