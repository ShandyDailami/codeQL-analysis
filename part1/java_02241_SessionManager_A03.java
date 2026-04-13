import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_02241_SessionManager_A03 {
    private static SessionManager instance;

    private java_02241_SessionManager_A03() {
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private Connection connection;

    public Connection getConnection() {
        if (connection == null) {
            String url = "jdbc:mysql://localhost:3306/test";
            String username = "root";
            String password = "root";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, username, password);
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
}