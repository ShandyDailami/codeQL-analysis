import java.sql.*;

public class java_10012_JDBCQueryHandler_A01 {
    private Connection connection;

    public java_10012_JDBCQueryHandler_A01(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}