import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_22981_SessionManager_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static SessionManager instance;
    private java.sql.SessionFactory sessionFactory;

    private java_22981_SessionManager_A03() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sessionFactory = java.sql.Session.builder()
                .setUrl(URL)
                .setUsername(USER)
                .setPassword(PASSWORD)
                .build();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public java.sql.Session openSession() {
        return sessionFactory.openSession();
    }

    public void closeSession(java.sql.Session session) {
        if (session != null) {
            session.close();
        }
    }
}