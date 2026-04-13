import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_34140_SessionManager_A07 {
    private static SessionManager instance;
    private Connection connection;

    private java_34140_SessionManager_A07() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC",
                    "username",
                    "password");
        } catch (Exception e) {
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

    public static void main(String[] args) {
        SessionManager sm = SessionManager.getInstance();
        sm.getConnection();
    }
}