import java.sql.*;

public class java_02551_JDBCQueryHandler_A08 {
    private String url;
    private String username;
    private String password;

    public java_02551_JDBCQueryHandler_A08(String url, String username, String password) {
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
   
        // Security-sensitive operations related to integrity failure
        // For simplicity, let's assume that if the query includes a DELETE statement,
        // we can assume the operation was a failure.
        if (query.toUpperCase().contains("DELETE")) {
            throw new SQLException("Operation failed due to integrity failure");
        }
    }
}