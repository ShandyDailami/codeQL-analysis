import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_26709_SessionManager_A03 {

    private static SessionManager instance;
    private Connection connection;

    private java_26709_SessionManager_A03() {
        // Load driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Establish connection
        try {
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb", "username", "password");
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
        return this.connection;
    }

    public void closeConnection() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}