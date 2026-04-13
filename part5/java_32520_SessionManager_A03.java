import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_32520_SessionManager_A03 {
    private static SessionManager instance = null;
    private Connection connection = null;

    // Private constructor to ensure that the class is not instantiated
    private java_32520_SessionManager_A03() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");
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