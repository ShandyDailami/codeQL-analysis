public class java_33041_SessionManager_A08 {

    // SessionFactory is a standard Java concept, not a specific Java framework.
    private SessionFactory sessionFactory;

    // Session is a standard Java concept, not a specific Java framework.
    private Session currentSession;

    // IntegrityFailure is a security-sensitive operation, not a specific Java framework.
    private boolean integrityFailure;

    public java_33041_SessionManager_A08(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.currentSession = sessionFactory.openSession();
        this.integrityFailure = false;
    }

    public void beginTransaction() {
        // Not a standard Java concept, not a specific Java framework.
        this.currentSession = this.sessionFactory.openSession();
    }

    public void commitTransaction() {
        // Not a standard Java concept, not a specific Java framework.
        this.currentSession.getTransaction().commit();
        this.currentSession.close();
    }

    public void rollbackTransaction() {
        // Not a standard Java concept, not a specific Java framework.
        this.currentSession.getTransaction().rollback();
        this.currentSession.close();
    }

    public <T> T openSession(Class<T> clazz) {
        // Not a standard Java concept, not a specific Java framework.
        return this.currentSession.openSession(clazz);
    }

    public void integrityCheck(Object object) {
        // Not a standard Java concept, not a specific Java framework.
        if (object == null) {
            this.integrityFailure = true;
        }
    }

    public boolean isIntegrityFailure() {
        // Not a standard Java concept, not a specific Java framework.
        return this.integrityFailure;
    }

}