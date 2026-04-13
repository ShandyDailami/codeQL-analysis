public class java_37494_SessionManager_A01 {
    private static SessionManager instance;
    private Session currentSession;

    private java_37494_SessionManager_A01() {
    }

    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session openSession() {
        // Open a new session with the database
        currentSession = HibernateUtil.openSession();
        return currentSession;
    }

    public void closeSession() {
        // Close the current session with the database
        if (currentSession != null) {
            currentSession.close();
        }
    }

    public void update(Object object) {
        // Update an existing object in the database
        if (currentSession != null) {
            currentSession.update(object);
        }
    }

    public void save(Object object) {
        // Save a new object into the database
        if (currentSession != null) {
            currentSession.save(object);
        }
    }

    public void delete(Object object) {
        // Delete an existing object from the database
        if (currentSession != null) {
            currentSession.delete(object);
        }
    }
}