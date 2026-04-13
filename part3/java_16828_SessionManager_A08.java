public class java_16828_SessionManager_A08 {

    private Session session;

    public java_16828_SessionManager_A08(Session session) {
        this.session = session;
    }

    public void openSession() {
        // Starts the session and retrieves the session configuration.
        session = sessionFactory.openSession();
    }

    public void closeSession() {
        // Closes the session and retrieves the session configuration.
        session.close();
    }

    public Session getSession() {
        return session;
    }

    public void update(String hql) {
        // Update the session configuration.
        session.createQuery(hql).executeUpdate();
    }

    public void persist(Object object) {
        // Save the object into the database.
        session.persist(object);
    }
}