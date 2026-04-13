import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_00464_SessionManager_A03 {

    private SessionFactory sessionFactory;

    public java_00464_SessionManager_A03(String driver, String url, String username, String password) {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sessionFactory = new org.hibernate.cfg.Configuration()
                .setDriver("com.mysql.jdbc.Driver")
                .setJDBC(url)
                .setUser(username)
                .setPassword(password)
                .addAnnotatedClass(Session.class)
                .buildSessionFactory();
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        session.close();
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/test?useSSL=false", "username", "password");
        Session session = sessionManager.openSession();
        session.beginTransaction();
        // Perform your operations here
        session.getTransaction().commit();
        sessionManager.closeSession(session);
    }
}