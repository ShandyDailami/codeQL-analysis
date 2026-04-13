public class java_11795_SessionManager_A03 {

    private SessionFactory sessionFactory;

    public java_11795_SessionManager_A03() {
        // Create a new session factory
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void openSession(String userId) {
        // Secure operation: avoid SQL Injection
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }

        // Open a new session
        Session session = sessionFactory.openSession();

        // Perform a security-sensitive operation (e.g., save a user to the database)
        // ...

        // Close the session
        session.close();
    }
}