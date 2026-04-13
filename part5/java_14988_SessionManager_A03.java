public class java_14988_SessionManager_A03 {
    private static SessionManager instance;
    private Session session;

    private java_14988_SessionManager_A03() {
        // Create a new session
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            session = SessionFactory.openSession("username", "password", "jdbc:mysql://localhost:3306/db");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session getSession() {
        return session;
    }
}