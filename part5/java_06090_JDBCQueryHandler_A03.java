import java.sql.*;

public class java_06090_JDBCQueryHandler_A03 {
    private Connection connection;
    private PreparedStatement statement;

    public java_06090_JDBCQueryHandler_A03(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String query, String parameterName, Object parameterValue) throws SQLException {
        this.statement = this.connection.prepareStatement(query);
        this.statement.setObject(parameterName, parameterValue);
        return this.statement.executeQuery();
    }

    public void executeUpdate(String query, String parameterName, Object parameterValue) throws SQLException {
        this.statement = this.connection.prepareStatement(query);
        this.statement.setObject(parameterName, parameterValue);
        this.statement.executeUpdate();
    }

    public void close() throws SQLException {
        this.statement.close();
        this.connection.close();
    }
}