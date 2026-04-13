public class java_25690_SessionManager_A08 {

    public Session openSession() {
        // Assume a successful open session
        return new Session();
    }

    public void closeSession(Session session) {
        // Throw a security exception when closing a session
        if(session != null) {
            throw new SecurityException("Attempted to close a session.");
        }
    }

    public void update(Session session, String sql) {
        // Throw a security exception when updating a session
        if(session != null && sql != null) {
            throw new SecurityException("Attempted to update a session.");
        }
    }

    public void delete(Session session) {
        // Throw a security exception when deleting a session
        if(session != null) {
            throw new SecurityException("Attempted to delete a session.");
        }
    }

}