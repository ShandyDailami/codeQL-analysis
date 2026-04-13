import java.sql.*;

public class java_12788_JDBCQueryHandler_A07 {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public java_12788_JDBCQueryHandler_A07(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        resultSet = statement.executeQuery(query);
        return resultSet;
    }

    public void executeUpdate(String query) throws SQLException {
        statement.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}