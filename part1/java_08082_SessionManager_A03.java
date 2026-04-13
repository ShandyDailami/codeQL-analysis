import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_08082_SessionManager_A03 {

    private static SessionManager instance;
    private SessionFactory sessionFactory;

    private java_08082_SessionManager_A03() {
        String url = "jdbc:mysql://localhost:3306/db";
        String username = "username";
        String password = "password";
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}