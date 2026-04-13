import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_30022_SessionManager_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public PreparedStatement prepareStatement(Connection connection, String query) throws SQLException {
        return connection.prepareStatement(query);
    }

    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public void closeStatement(PreparedStatement statement) throws SQLException {
        statement.close();
    }
}