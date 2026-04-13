public class java_36954_SessionManager_A08 {

    private Session session;
    private Transaction transaction;

    public java_36954_SessionManager_A08(EntityManager em) {
        session = em.unwrap(Session.class);
    }

    public void beginTransaction() {
        transaction = session.beginTransaction();
    }

    public void commitTransaction() {
        transaction.commit();
    }

    public void rollbackTransaction() {
        transaction.rollback();
    }

    public void save(Object entity) {
        session.save(entity);
    }

    public void update(Object entity) {
        session.update(entity);
    }

    public void delete(Object entity) {
        session.delete(entity);
    }

    public void integrityFailure() {
        try {
            session.doWork();
        } catch (RuntimeException e) {
            // Handle the integrity failure here
            rollbackTransaction();
            throw e;
        } finally {
            commitTransaction();
        }
    }
}