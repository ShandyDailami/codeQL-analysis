import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_39591_SessionManager_A01 {
    private static SessionManager instance;

    private java_39591_SessionManager_A01() {}

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private Connection connection;

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");
        }
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            SessionManager sm = SessionManager.getInstance();
            Connection connection = sm.getConnection();

            // perform your operations here

            sm.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}