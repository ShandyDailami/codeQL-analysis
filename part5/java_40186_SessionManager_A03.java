import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_40186_SessionManager_A03 {
    private static SessionManager instance;

    private java_40186_SessionManager_A03() {
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private Connection connection;

    public Connection getConnection() {
        if (connection == null || connection.isClosed()) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
            } catch (SQLException e) {
                System.out.println("Error while connecting to the database");
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void closeConnection() {
        if (connection != null && !connection.isClosed()) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error while closing the database connection");
                e.printStackTrace();
            }
        }
        connection = null;
    }

    public void executeQuery(String query) {
        Connection conn = getConnection();
        try {
            conn.createStatement().executeUpdate(query);
            System.out.println("Query executed successfully");
        } catch (SQLException e) {
            System.out.println("Error while executing query: " + query);
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
}