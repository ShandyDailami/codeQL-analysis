public class java_03534_SessionManager_A01 {
    // Singleton SessionManager instance
    private static SessionManager instance;

    // Private constructor to restrict instantiation
    private java_03534_SessionManager_A01() {}

    // Method to get the instance of SessionManager
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    // Session object
    private Session session;

    // Method to open a session
    public void openSession() {
        // Connect to the database and open a session
        session = HibernateUtil.getSessionFactory().openSession();
    }

    // Method to close the session
    public void closeSession() {
        // Close the session and commit the transaction
        session.close();
    }

    // Method to begin a transaction
    public void beginTransaction() {
        // Begin a transaction
        session.beginTransaction();
    }

    // Method to commit a transaction
    public void commitTransaction() {
        // Commit the transaction
        session.getTransaction().commit();
    }

    // Method to rollback a transaction
    public void rollbackTransaction() {
        // Rollback the transaction
        session.getTransaction().rollback();
    }
}