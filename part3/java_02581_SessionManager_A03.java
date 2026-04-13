import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_02581_SessionManager_A03 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "root";
    private static final String password = "root";
    private static SessionFactory sessionFactory;

    static {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void main(String[] args) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        User user = new User();
        user.setName("John Doe");
        user.setEmail("john@doe.com");
        user.setPassword("johnspassword");

        session.save(user);

        transaction.commit();
        session.close();
    }
}