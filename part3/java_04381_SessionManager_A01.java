public class java_04381_SessionManager_A01 {

    // SessionFactory is a factory for creating sessions
    private SessionFactory sessionFactory;

    public java_04381_SessionManager_A01(String xmlFilePath) {
        // Initialize the session factory
        sessionFactory = new Configuration().configure(xmlFilePath).buildSessionFactory();
    }

    public Session openSession() {
        // Open a new session
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        // Close a session
        if (session != null) {
            session.close();
        }
    }

    public <T> T find(Session session, Class<T> clazz, int id) {
        // Find an entity by its ID
        return session.get(clazz, id);
    }

    public <T> void save(Session session, T entity) {
        // Save an entity
        session.save(entity);
    }

    public <T> void update(Session session, T entity) {
        // Update an entity
        session.update(entity);
    }

    public <T> void delete(Session session, T entity) {
        // Delete an entity
        session.delete(entity);
    }
}