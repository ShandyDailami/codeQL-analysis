public class java_31432_SessionManager_A08 {

    private Session session;
    private String connectionString;
    private String username;
    private String password;

    public java_31432_SessionManager_A08(String connectionString, String username, String password) {
        this.connectionString = connectionString;
        this.username = username;
        this.password = password;
    }

    public void openSession() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
        } catch (Exception e) {
            throw new SessionException("Failed to open session", e);
        }
    }

    public void closeSession() {
        try {
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            throw new SessionException("Failed to close session", e);
        }
    }

    public void insert(Object entity) {
        try {
            session.save(entity);
        } catch (IntegrityFailureException e) {
            throw new SessionException("Integrity failure while inserting entity", e);
        }
    }

    public void update(Object entity) {
        try {
            session.update(entity);
        } catch (IntegrityFailureException e) {
            throw new SessionException("Integrity failure while updating entity", e);
        }
    }

    public void delete(Object entity) {
        try {
            session.delete(entity);
        } catch (IntegrityFailureException e) {
            throw new SessionException("Integrity failure while deleting entity", e);
        }
    }
}