public class java_11478_SessionManager_A08 {
    private Session session;

    public java_11478_SessionManager_A08() {
        // Create a session using the Hibernate configuration
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void closeSession() {
        // Check if the session is not null
        if (session != null) {
            // Close the session
            session.close();
            session = null;
        }
    }

    public static void main(String[] args) {
        // Create a session manager
        SessionManager sessionManager = new SessionManager();

        // Start a transaction
        sessionManager.session.beginTransaction();

        // Perform some operations
        // ...

        // Commit the transaction
        sessionManager.session.getTransaction().commit();

        // Close the session manager
        sessionManager.closeSession();
    }
}