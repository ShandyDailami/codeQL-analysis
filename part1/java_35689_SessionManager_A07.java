import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_35689_SessionManager_A07 {
    private static SessionManager instance = null;

    private java_35689_SessionManager_A07() {
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private Connection connection = null;

    public Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/legacy_db", "username", "password");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
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

    public static void main(String[] args) {
        SessionManager sm = SessionManager.getInstance();
        Connection connection = sm.getConnection();

        // Here you can add the code related to authentication failure

        sm.closeConnection();
    }
}