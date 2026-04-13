import java.sql.*;

public class java_23520_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_23520_JDBCQueryHandler_A03(String url, String username, String password) throws SQLException {
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