public class java_02089_SessionManager_A08 {

    private Session session;

    public java_02089_SessionManager_A08(Session session) {
        this.session = session;
    }

    public void openSession() {
        if (session == null) {
            throw new IllegalStateException("Session is already closed.");
        }
    }

    public void closeSession() {
        if (session != null) {
            session.close();
            session = null;
        } else {
            throw new IllegalStateException("Session is already open.");
        }
    }

    public Session getSession() {
        return session;
    }
}