import java.sql.*;

public class java_36717_JDBCQueryHandler_A08 {

    private Connection connection;

    public java_36717_JDBCQueryHandler_A08(String dbUrl, String userName, String password) throws SQLException {
        connection = DriverManager.getConnection(dbUrl, userName, password);
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