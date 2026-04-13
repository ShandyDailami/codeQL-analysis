import java.sql.*;

public class java_21965_JDBCQueryHandler_A03 {

    private Connection connection;
    private PreparedStatement statement;

    public java_21965_JDBCQueryHandler_A03(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }

    public void executeUpdate(String query) throws SQLException {
        statement = connection.prepareStatement(query);
        statement.executeUpdate();
    }

    public void close() throws SQLException {
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}