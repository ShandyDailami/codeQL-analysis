import java.sql.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_28933_SessionManager_A03 {

    private static ExecutorService executorService;
    private static Connection connection;

    static {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            executorService = Executors.newFixedThreadPool(10);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        // Perform security-sensitive operations here
        // For example, create a new session, run a query, and then close the session
        try {
            Session session = connection.openSession();
            Query query = session.createQuery("FROM User WHERE username = :username");
            query.setParameter("username", "admin");
            User user = (User) query.uniqueResult();
            session.close();
            // Perform further security-sensitive operations here
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}