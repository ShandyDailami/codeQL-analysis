public class java_32293_SessionManager_A08 {
    private static SessionManager sessionManager;
    private Session session;

    private java_32293_SessionManager_A08() {
        // private constructor to prevent instantiation
    }

    public static SessionManager getSessionManager() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public void openSession() {
        // Open a new session if one doesn't exist already.
        if (session == null || !session.isOpen()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
    }

    public void closeSession() {
        // Close the session if it exists.
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public void startTransaction() {
        // Start a transaction if none exists already.
        if (session != null && !session.getTransaction().isActive()) {
            session.getTransaction().begin();
        }
    }

    public void commitTransaction() {
        // Commit the transaction if it exists and is active.
        if (session != null && session.getTransaction().isActive()) {
            session.getTransaction().commit();
        }
    }

    public void rollbackTransaction() {
        // Rollback the transaction if it exists and is active.
        if (session != null && session.getTransaction().isActive()) {
            session.getTransaction().rollback();
        }
    }

    public void integrityFailure() {
        // This operation is security-sensitive and should fail due to lack of a transaction.
        // It should not be able to execute if the session is not open or there is no active transaction.
        if (session != null && !session.getTransaction().isActive()) {
            session.close();
        } else {
            System.out.println("No transaction found!");
        }
    }
}