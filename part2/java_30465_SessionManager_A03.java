import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_30465_SessionManager_A03 {
    private static SessionManager instance;
    private static SessionFactory sessionFactory;

    private java_30465_SessionManager_A03() {
        // Load Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Create Connection Pool
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session getSession() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return session;
    }
}