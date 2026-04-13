import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_07269_SessionManager_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    public void closeConnection(Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public PreparedStatement getPreparedStatement(Connection connection, String query) throws SQLException {
        return connection.prepareStatement(query);
    }

    public void closePreparedStatement(PreparedStatement statement) throws SQLException {
        if (statement != null) {
            statement.close();
        }
    }

    public void executeQuery(PreparedStatement statement) throws SQLException {
        statement.execute();
        closePreparedStatement(statement);
    }

    public static void main(String[] args) {
        SecureSessionManager sessionManager = new SecureSessionManager();

        Connection connection = sessionManager.getConnection();
        PreparedStatement statement = sessionManager.getPreparedStatement(connection, "SELECT * FROM Users WHERE username = ?");

        statement.setString(1, "testUser");

        sessionManager.executeQuery(statement);
        sessionManager.closeConnection(connection);
    }
}