import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_12889_SessionManager_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection connection;

    public void openConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        if (connection == null || connection.isClosed()) {
            openConnection();
        }
        return connection;
    }

    public void closeConnection() {
        if (connection != null && !connection.isClosed()) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.openConnection();

        // Security-sensitive operation
        String injection = "INSERT INTO users(username, password) VALUES('injector', 'injection')";

        try {
            connection.prepareStatement(injection).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        manager.closeConnection();
    }
}