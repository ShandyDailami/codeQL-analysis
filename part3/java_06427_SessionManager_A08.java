import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_06427_SessionManager_A08 {

    private Connection connection;

    public java_06427_SessionManager_A08(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    public void startSession() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");
        }
    }

    public void manageSession(String operation) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            // Do some work here...
            System.out.println("Managing session: " + operation);
        } else {
            System.out.println("No active session, starting a new one...");
            startSession();
        }
    }

    public void closeSession() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            connection = null;
            System.out.println("Closed session");
        } else {
            System.out.println("No active session to close");
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = null;
        try {
            sessionManager = new SessionManager("jdbc:mysql://localhost:3306/testdb", "username", "password");
            sessionManager.startSession();
            sessionManager.manageSession("Operation 1");
            sessionManager.manageSession("Operation 2");
            sessionManager.closeSession();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (sessionManager != null) {
                sessionManager.closeSession();
            }
        }
    }
}