import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_12625_SessionManager_A03 {
    private Connection connection;

    // Constructor Injection
    public java_12625_SessionManager_A03(Connection connection) {
        this.connection = connection;
    }

    public void openSession() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root");
        }
    }

    public void closeSession() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            connection = null;
        }
    }

    public Connection getConnection() {
        return connection;
    }
}

public class Main {
    public static void main(String[] args) throws SQLException {
        SessionManager sessionManager = new SessionManager(null);
        sessionManager.openSession();

        Connection connection = sessionManager.getConnection();
        // ... use the connection here

        sessionManager.closeSession();
    }
}