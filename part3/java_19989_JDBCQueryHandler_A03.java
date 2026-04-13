import java.sql.*;

public class java_19989_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_19989_JDBCQueryHandler_A03(String dbUrl, String userName, String password) throws SQLException {
        this.connection = DriverManager.getConnection(dbUrl, userName, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }

    public void executeUpdate(String query) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        statement.executeUpdate();
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}