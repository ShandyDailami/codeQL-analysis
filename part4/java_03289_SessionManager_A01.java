public class java_03289_SessionManager_A01 {
    private static SessionManager instance;
    private Session session;

    private java_03289_SessionManager_A01() {
        // Use JDBC to open a database session
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            session = SessionFactoryBuilder.build().openSession();
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
        return this.session;
    }
}