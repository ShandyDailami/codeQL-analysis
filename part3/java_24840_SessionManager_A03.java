public class java_24840_SessionManager_A03 {
    private Session session;

    public java_24840_SessionManager_A03(Session session) {
        this.session = session;
    }

    public Session getSession() {
        // Start a new session if one doesn't exist, or get the existing one if one does
        if (session == null || session.getStatus() == Connection.Status.CLOSED) {
            session = this.createSession();
        }
        return session;
    }

    private Session createSession() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD)
                    .createSession();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}