import java.sql.*;

public class java_18152_JDBCQueryHandler_A01 {
    private String url;
    private String username;
    private String password;

    public java_18152_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }
}