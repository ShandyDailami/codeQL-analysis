import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_23895_SessionManager_A03 {

    // Define the URL, username, and password for the database
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Define the connection pool size
    private static final int POOL_SIZE = 10;

    private static Connection[] connections;

    // Initialize the connections
    static {
        connections = new Connection[POOL_SIZE];
        for (int i = 0; i < POOL_SIZE; i++) {
            connections[i] = createConnection();
        }
    }

    // Create a new connection
    private static Connection createConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Get a connection from the pool
    public static Connection getConnection() {
        Connection connection = null;
        if (connections != null && !connections.isEmpty()) {
            connection = connections[0];
            connections[0] = null;
        }
        return connection;
    }

    // Return a connection back to the pool
    public static void returnConnection(Connection connection) {
        if (connection != null) {
            connections[connectionToIndex(connection)] = connection;
        }
    }

    // Get the index of a connection in the pool
    private static int connectionToIndex(Connection connection) {
        for (int i = 0; i < connections.length; i++) {
            if (connections[i] == connection) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Use the session manager to get a connection
        try {
            Connection connection = getConnection();
            if (connection != null) {
                // Create and execute a query
                String query = "SELECT * FROM users";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("username"));
                }
                // Return the connection back to the pool
                returnConnection(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}