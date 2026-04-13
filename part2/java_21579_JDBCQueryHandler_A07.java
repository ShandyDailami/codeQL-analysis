import java.sql.*;

public class java_21579_JDBCQueryHandler_A07 {
    private Connection connection;

    public java_21579_JDBCQueryHandler_A07(String dbUrl, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(dbUrl, user, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}