public class java_27549_SessionManager_A08 {

    // Declare a field to hold the current Session
    private Session currentSession;

    // Constructor
    public java_27549_SessionManager_A08(Session session) {
        this.currentSession = session;
    }

    // Method to begin a new transaction
    public void beginTransaction() {
        try {
            this.currentSession.beginTransaction();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Method to commit the current transaction
    public void commitTransaction() {
        try {
            this.currentSession.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Method to save the session
    public void save(Object entity) {
        try {
            this.currentSession.save(entity);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Method to update the session
    public void update(Object entity) {
        try {
            this.currentSession.update(entity);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Method to delete the session
    public void delete(Object entity) {
        try {
            this.currentSession.delete(entity);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

public class Main {

    public static void main(String[] args) {

        // Create a SessionFactory
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        // Create a Session
        Session session = sessionFactory.openSession();

        // Create a SessionManager
        SessionManager sessionManager = new SessionManager(session);

        // Begin a transaction
        sessionManager.beginTransaction();

        // Save a user
        User user = new User();
        user.setName("John Doe");
        sessionManager.save(user);

        // Commit the transaction
        sessionManager.commitTransaction();

        session.close();
    }
}