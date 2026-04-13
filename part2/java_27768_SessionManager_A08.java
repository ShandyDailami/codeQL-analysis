import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Session;
import java.sql.SessionException;

public class java_27768_SessionManager_A08 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static SessionFactory sessionFactory;

    static {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            sessionFactory = new org.hibernate.cfg.Configuration()
                    .configure()
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session openSession() throws SessionException {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        Session session = openSession();

        try {
            session.beginTransaction();

            // do something with session

            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}