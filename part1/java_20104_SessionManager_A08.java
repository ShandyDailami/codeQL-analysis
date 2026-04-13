import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_20104_SessionManager_A08 {

    private static SessionManager instance = null;
    private Connection conn = null;

    // Private constructor to prevent instantiation
    private java_20104_SessionManager_A08() {
        createConnection();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private void createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_name", "username", "password");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conn;
    }
}