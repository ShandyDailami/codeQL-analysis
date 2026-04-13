import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_09630_SessionManager_A03 {
    private static SessionManager instance;
    private Connection connection;

    private java_09630_SessionManager_A03() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb?useSSL=false", "username", "password");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle exception
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

    public void close() {
        try {
            if (this.connection != null) {
                this.connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
    }
}