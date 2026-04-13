import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_04957_SessionManager_A01 {

    private static SessionManager instance;
    private Connection connection;

    private java_04957_SessionManager_A01() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC driver
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "username", "password");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}