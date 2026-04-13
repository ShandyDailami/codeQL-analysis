import java.sql.*;

public class java_19738_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_19738_JDBCQueryHandler_A03(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }

    public void close() throws SQLException {
        connection.close();
    }
}