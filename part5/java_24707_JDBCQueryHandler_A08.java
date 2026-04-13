import java.sql.*;

public class java_24707_JDBCQueryHandler_A08 {
    private Connection connection;
    private Statement statement;

    public java_24707_JDBCQueryHandler_A08(String dbURL, String userName, String password) throws SQLException {
        connection = DriverManager.getConnection(dbURL, userName, password);
        statement = connection.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        statement.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        statement.close();
        connection.close();
    }
}