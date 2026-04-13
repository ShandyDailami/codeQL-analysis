import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Session;

public class java_05270_SessionManager_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private SessionFactory sessionFactory;

    public java_05270_SessionManager_A03() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        session.close();
    }

    public void execute(String query, Session session) {
        Transaction transaction = session.beginTransaction();
        session.createQuery(query).executeUpdate();
        transaction.commit();
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        Session session = sessionManager.openSession();

        sessionManager.execute("INSERT INTO USERS (username, password) VALUES (:username, :password)", session);

        sessionManager.closeSession(session);
    }
}