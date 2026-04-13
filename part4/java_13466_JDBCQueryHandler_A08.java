import java.sql.*;

public class java_13466_JDBCQueryHandler_A08 {
    private String url;
    private String username;
    private String password;

    public java_13466_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        return statement.executeUpdate(query);
    }

    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }
}