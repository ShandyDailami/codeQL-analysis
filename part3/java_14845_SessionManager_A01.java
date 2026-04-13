import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_14845_SessionManager_A01 {
    private String url;
    private String username;
    private String password;
    private Connection connection;

    public java_14845_SessionManager_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public class SensitiveOperation {
    private SessionManager sessionManager;

    public java_14845_SessionManager_A01(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public void performSensitiveOperation() {
        Connection connection = sessionManager.getConnection();
        // Perform sensitive operation using the connection here...
        sessionManager.closeConnection();
    }
}

public class BrokenAccessControl {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager("jdbc:mysql://localhost:3306/test", "username", "password");
        SensitiveOperation sensitiveOperation = new SensitiveOperation(sessionManager);

        // Attempt to perform sensitive operation without authentication
        sensitiveOperation.performSensitiveOperation();
    }
}