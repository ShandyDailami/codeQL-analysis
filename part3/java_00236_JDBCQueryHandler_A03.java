import java.sql.*;

public class java_00236_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_00236_JDBCQueryHandler_A03(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public void close() throws SQLException {
        connection.close();
    }
}