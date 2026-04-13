import java.sql.*;

public class java_15923_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_15923_JDBCQueryHandler_A03(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

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