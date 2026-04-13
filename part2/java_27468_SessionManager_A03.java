import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_27468_SessionManager_A03 {
    private static SessionManager instance = null;
    private Connection connection = null;

    private java_27468_SessionManager_A03() {
        String url = "jdbc:mysql://localhost:3306/db_example";
        String username = "root";
        String password = "password";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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