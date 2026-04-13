import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class java_22398_SessionManager_A07 {
    private static List<Connection> connections = new ArrayList<>();
    private static final int MAX_CONNECTIONS = 10;

    public static Connection getConnection() {
        if (connections.isEmpty()) {
            createNewConnection();
        }

        Connection connection = connections.remove(0);
        connections.add(connection);

        return connection;
    }

    private static void createNewConnection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:your_db_url", "username", "password");
            if (connection != null) {
                connections.add(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void releaseConnection(Connection connection) {
        connections.add(connection);
    }
}