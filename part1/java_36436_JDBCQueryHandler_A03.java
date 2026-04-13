import java.sql.*;

public class java_36436_JDBCQueryHandler_A03 {

    private Connection connection;

    // Inject database connection via the constructor
    public java_36436_JDBCQueryHandler_A03(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    // Security-sensitive operations for A03_Injection
    public ResultSet executeQuery(String query) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }

    public void executeUpdate(String query) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        statement.executeUpdate();
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}