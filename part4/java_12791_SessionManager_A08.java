public class java_12791_SessionManager_A08 {
    private static SessionManager instance;
    private Session session;

    private java_12791_SessionManager_A08() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            session = HikariDataSource().getConnection("jdbc:mysql://localhost/test", "user", "password").createSession();
        } catch (Exception e) {
            System.out.println("Error while setting up database connection: " + e);
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

    public void closeSession() {
        session.close();
    }
}