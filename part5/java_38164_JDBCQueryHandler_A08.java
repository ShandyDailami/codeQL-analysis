import java.sql.*;

public class java_38164_JDBCQueryHandler_A08 {
    private Connection connection;

    public java_38164_JDBCQueryHandler_A08(String dbURL, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(dbURL, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}