public class java_18366_SessionManager_A07 {
    // Define a private instance of a SessionFactory
    private SessionFactory sessionFactory;

    public java_18366_SessionManager_A07() {
        // Initialize the session factory
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    // Method to open a session
    public Session openSession() {
        // Use the sessionFactory to open a new session
        return sessionFactory.openSession();
    }

    // Method to save a transactional object
    public void save(Object object) {
        // Open a session
        Session session = openSession();
        try {
            // Start a transaction
            session.beginTransaction();
            // Save the object
            session.save(object);
            // Commit the transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            // If there is an error, rollback the transaction
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            // Close the session
            session.close();
        }
    }

    // Method to retrieve an object
    public <T> T retrieve(Class<T> clazz, Serializable id) {
        // Open a session
        Session session = openSession();
        try {
            // Retrieve the object
            return session.get(clazz, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            // Close the session
            session.close();
        }
    }

    // Method to update an object
    public <T> void update(T object) {
        // Open a session
        Session session = openSession();
        try {
            // Start a transaction
            session.beginTransaction();
            // Update the object
            session.update(object);
            // Commit the transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            // If there is an error, rollback the transaction
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            // Close the session
            session.close();
        }
    }

    // Method to delete an object
    public <T> void delete(T object) {
        // Open a session
        Session session = openSession();
        try {
            // Start a transaction
            session.beginTransaction();
            // Delete the object
            session.delete(object);
            // Commit the transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            // If there is an error, rollback the transaction
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            // Close the session
            session.close();
        }
    }
}