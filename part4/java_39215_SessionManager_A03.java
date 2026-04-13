import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_39215_SessionManager_A03 {
    private static SessionManager instance;
    private Connection connection;

    private java_39215_SessionManager_A03() {
        // Load the driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Establish the connection
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dbname?useSSL=false", "username", "password");
        } catch (SQLException e) {
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