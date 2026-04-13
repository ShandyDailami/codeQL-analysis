import java.sql.*;

public class java_00843_JDBCQueryHandler_A03 {
    private Connection connection;
    private String dbUrl;
    private String username;
    private String password;

    public java_00843_JDBCQueryHandler_A03(String dbUrl, String username, String password) {
        this.dbUrl = dbUrl;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(dbUrl, username, password);
        }
        return connection;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement statement = conn.prepareStatement(query);
        return statement.executeQuery();
    }

    public void executeUpdate(String query) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement statement = conn.prepareStatement(query);
        statement.executeUpdate();
    }
}