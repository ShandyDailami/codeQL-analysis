import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Session;
import java.sql.SQLException;

public class java_00312_SessionManager_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private SessionFactory sessionFactory;

    public java_00312_SessionManager_A08() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            sessionFactory = createSessionFactory();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private SessionFactory createSessionFactory() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return new Configuration().configure().buildSessionFactory();
    }

    public Session openSession() throws SQLException {
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        Session session = null;
        try {
            session = sessionManager.openSession();
            session.beginTransaction();

            // Example of security-sensitive operation
            // Do not execute this line without proper authorization
            session.createQuery("SELECT * FROM Users WHERE id = :id").setParameter("id", 1).list();

            session.getTransaction().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sessionManager.closeSession(session);
        }
    }
}