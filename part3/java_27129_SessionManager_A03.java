import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_27129_SessionManager_A03 {
    private static SessionManager instance = null;
    private Connection connection = null;

    // Private constructor to prevent instantiation of the class
    private java_27129_SessionManager_A03() {
        try {
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb", "root", "password");
            this.connection.setAutoCommit(false);
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