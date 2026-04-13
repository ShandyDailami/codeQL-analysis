import java.sql.*;

public class java_15482_JDBCQueryHandler_A08 {
    private Connection connection;
    private Statement statement;

    public java_15482_JDBCQueryHandler_A08(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        statement.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}