import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_24490_SessionManager_A01 {
    private static SessionManager instance;
    private Connection connection;

    private java_24490_SessionManager_A01() {
        try {
            // Using JDBC to connect to the database
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
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