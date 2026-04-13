import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_39996_SessionManager_A08 {
    private static SessionManager instance;
    private Connection connection;

    private java_39996_SessionManager_A08() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC", "username", "password");
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