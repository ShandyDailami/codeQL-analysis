import java.sql.*;

public class java_22483_JDBCQueryHandler_A07 {
    private Connection connection;

    public java_22483_JDBCQueryHandler_A07(String dbURL, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(dbURL, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        if (connection != null && connection.isClosed()) {
            connection.close();
        }
    }
}