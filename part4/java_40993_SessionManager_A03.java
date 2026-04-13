import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_40993_SessionManager_A03 {

    private static SecuritySessionManager instance;
    private Connection connection;

    // Private constructor to restrict instantiation of the class from other classes
    private java_40993_SessionManager_A03() {
        instance = this;
        establishConnection();
    }

    public static SecuritySessionManager getInstance() {
        if (instance == null) {
            instance = new SecuritySessionManager();
        }
        return instance;
    }

    private void establishConnection() {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "username";
        String password = "password";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}