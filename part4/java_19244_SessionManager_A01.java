import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_19244_SessionManager_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        try (Connection connection = sessionManager.getConnection()) {
            // Perform operations on the connection here.
            // For example, we can create a table.
            connection.createStatement().executeUpdate(
                    "CREATE TABLE Users (" +
                            "id INT AUTO_INCREMENT PRIMARY KEY," +
                            "username VARCHAR(50) NOT NULL," +
                            "password VARCHAR(50) NOT NULL" +
                            ")");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                sessionManager.closeConnection(null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}