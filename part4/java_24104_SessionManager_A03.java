import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;

public class java_24104_SessionManager_A03 {
    private static final Stack<Connection> dataStore = new Stack<>();
    private static final int MAX_CONNECTIONS = 10;
    private static int currentConnections = 0;

    private java_24104_SessionManager_A03() {
    }

    private static class SessionManagerHelper {
        private static final SessionManager INSTANCE = new SessionManager();
    }

    public static SessionManager getInstance() {
        return SessionManagerHelper.INSTANCE;
    }

    public Connection getConnection() throws SQLException {
        if (currentConnections < MAX_CONNECTIONS) {
            currentConnections++;
            return DriverManager.getConnection("jdbc:mysql://localhost/testdb", "root", "password");
        } else {
            throw new SQLException("Maximum connections reached");
        }
    }

    public void closeConnection(Connection connection) {
        dataStore.push(connection);
        currentConnections--;
    }
}