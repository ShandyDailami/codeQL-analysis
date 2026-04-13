import java.sql.*;

public class java_08289_JDBCQueryHandler_A08 {
    private Connection connection;
    private Statement statement;

    public java_08289_JDBCQueryHandler_A08(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return statement.executeQuery(query);
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