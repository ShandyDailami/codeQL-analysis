import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_26640_SessionManager_A08 {
    private static SessionManager instance = null;
    private Connection connection = null;

    // Private constructor to prevent instantiation from outside
    private java_26640_SessionManager_A08() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "password");
        } catch (ClassNotFoundException e) {
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
        try {
            if (this.connection != null && !this.connection.isClosed()) {
                this.connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}