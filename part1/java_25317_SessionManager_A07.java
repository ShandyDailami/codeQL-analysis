import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_25317_SessionManager_A07 {
    private static SessionManager instance = null;
    private Connection connection = null;

    private java_25317_SessionManager_A07() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydatabase", "username", "password");
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
}