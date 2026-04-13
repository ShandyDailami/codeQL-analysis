import java.sql.*;

public class java_06971_JDBCQueryHandler_A01 {
    private Connection connection;
    private Statement statement;

    public java_06971_JDBCQueryHandler_A01(String url, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
        this.statement = connection.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    public void close() throws SQLException {
        statement.close();
        connection.close();
    }
}