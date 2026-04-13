import java.sql.*;

public class java_29643_JDBCQueryHandler_A08 {
    private String url;
    private String username;
    private String password;

    public java_29643_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        // Add security-sensitive operations here
        // For example, verifying the connection and the result set
        if (!connection.isValid()) {
            throw new SQLException("Invalid connection");
        }

        if (resultSet == null) {
            throw new SQLException("No result set returned");
        }

        return resultSet;
    }

    public void executeUpdate(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        // Add security-sensitive operations here
        // For example, updating a table
        int affectedRows = statement.executeUpdate(query);

        if (affectedRows == 0) {
            throw new SQLException("No rows updated");
        }
    }
}