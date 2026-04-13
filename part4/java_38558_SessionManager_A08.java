public class java_38558_SessionManager_A08 {
    private Session currentSession;

    public Session openSession() {
        // Create a new Session and return it
        currentSession = Hibernate.openSession();
        return currentSession;
    }

    public void closeSession() {
        // Close the current Session
        if (currentSession != null) {
            currentSession.close();
        }
    }

    public void save(Object obj) {
        // Save the given object to the database
        if (currentSession != null) {
            currentSession.save(obj);
        }
    }

    public void update(Object obj) {
        // Update the given object in the database
        if (currentSession != null) {
            currentSession.update(obj);
        }
    }

    public void delete(Object obj) {
        // Delete the given object from the database
        if (currentSession != null) {
            currentSession.delete(obj);
        }
    }
}