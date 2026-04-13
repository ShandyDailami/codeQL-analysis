import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_01930_SessionManager_A01 {
    private Connection connection;
    private String url;
    private String username;
    private String password;

    public java_01930_SessionManager_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void openSession() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    public void closeSession() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public void secureOperation(Runnable operation) {
        // Secure operation: Access control
        if (connection != null && !connection.isClosed()) {
            operation.run();
        } else {
            System.out.println("Cannot perform operation. Session is not open.");
        }
    }
}