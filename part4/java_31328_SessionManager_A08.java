public class java_31328_SessionManager_A08 {
    // Define a SessionFactory
    private SessionFactory sessionFactory;

    // Constructor
    public java_31328_SessionManager_A08(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Method to open a session
    public Session openSession() {
        // Open a new session
        Session session = sessionFactory.openSession();

        // Add a transaction-managing method into the session
        session.beginTransaction();

        return session;
    }

    // Method to commit a transaction
    public void commitTransaction(Session session) {
        try {
            // Commit the transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            // Handle exception if there is one
            e.printStackTrace();
       
            // Always rollback if there is an exception
            session.getTransaction().rollback();
        }
    }

    // Method to close a session
    public void closeSession(Session session) {
        // Close the session
        session.close();
    }

    // Method to perform an integrity failure (A08_IntegrityFailure)
    public void performIntegrityFailure() {
        // Create a session
        Session session = openSession();

        // Create a new user
        User user = new User();
        user.setName("John Doe");

        // Save the user to the database
        session.save(user);

        // Commit the transaction
        commitTransaction(session);

        // Close the session
        closeSession(session);
    }
}