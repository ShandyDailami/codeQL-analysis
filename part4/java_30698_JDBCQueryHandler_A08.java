import java.sql.*;

public class java_30698_JDBCQueryHandler_A08 {
    private Connection connection;

    public java_30698_JDBCQueryHandler_A08(String dbUrl, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(dbUrl, user, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }

    public void executeUpdate(String query) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        statement.executeUpdate();
    }

    public void close() throws SQLException {
        connection.close();
    }
}