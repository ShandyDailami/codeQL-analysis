import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_14799_SessionManager_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        initializeSessionFactory();

        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            // Perform security-sensitive operations

            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initializeSessionFactory() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(MyEntity.class)
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}