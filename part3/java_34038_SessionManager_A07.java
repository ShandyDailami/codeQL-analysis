import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_34038_SessionManager_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            SessionFactory sessionFactory = connection.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            // Perform secure operation here

            session.getTransaction().commit();
            session.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}